package org.triplem.insurancedataservice.imports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.imports.util.ImportService;
import org.triplem.insurancedataservice.imports.util.ImportServiceChain;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;

import java.util.List;

@Service
public class ImportProcessor {

    private final ImportServiceChain importServiceChain;
    private final List<ImportService<?>> importServices;

    @Autowired
    public ImportProcessor(ImportServiceChain importServiceChain, ImportService<?>... importServices) {
        this.importServiceChain = importServiceChain;
        this.importServices = List.of(importServices);
        initDataProcessorChain();
    }

    private void initDataProcessorChain() {
        importServices.forEach(importServiceChain::append);
    }

    public boolean process(ImportData importData) {
        return importServiceChain.process(importData);
    }
}
