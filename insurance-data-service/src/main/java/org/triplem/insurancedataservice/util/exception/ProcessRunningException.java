package org.triplem.insurancedataservice.util.exception;


import org.triplem.insurancedataservice.imports.util.ImportData;

public class ProcessRunningException extends RuntimeException {

    private ImportData importData;

    public ProcessRunningException(ImportData processData) {
        this.importData = processData;
    }

    public ImportData getImportData() {
        return this.importData;
    }

}
