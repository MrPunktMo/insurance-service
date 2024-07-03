package org.triplem.insurancedataservice.imports.util;

import org.triplem.insurancedataservice.imports.wrapper.ImportData;
import org.triplem.insurancedataservice.imports.wrapper.Table;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public abstract class ImportService<C> {

    private ImportService<?> next;
    private final ImportDataPreparator<C> importDataPreparator;

    protected ImportService(ImportDataPreparator<C> importDataPreparator) {
        this.importDataPreparator = importDataPreparator;
    }

    protected boolean importData(ImportData importData, ImportService<C> importService) {
        boolean isImported = false;
        Class<C> dataClass = (Class<C>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        importService.truncateTable();
        importService.saveImportData(importDataPreparator.getInsertData(dataClass, initImportObjects(importService, importData.getImportAmount()), importData.getValues()));
        return isImported;
    }

    private List<C> initImportObjects(ImportService<C> importService, Long amount) {
        List<C> importObjects = new ArrayList<>();
        while(importObjects.size() < amount) {
            importObjects.add(importService.initImportObject());
        }
        return importObjects;
    }

    public void setNext(ImportService<?> importService) {
        this.next = importService;
    }

    protected boolean sendToNext(ImportData importData) {
        if(this.next != null)
            return this.next.processImport(importData);
        else
            return false;
    }

    public boolean processImport(ImportData importData) {
        if(isImportTable(importData.getTable()))
           return startImport(importData);
        else
           return sendToNext(importData);
    }

    private boolean isImportTable(Table table) {
        return table.getName().equals(this.getImportTableName());
    }

    protected abstract String getImportTableName();

    protected abstract boolean startImport(ImportData importData);

    protected abstract C initImportObject();

    protected abstract void saveImportData(List<C> importData);

    protected abstract void truncateTable();

}
