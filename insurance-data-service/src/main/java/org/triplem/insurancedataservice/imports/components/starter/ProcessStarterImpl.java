package org.triplem.insurancedataservice.imports.components.starter;

import org.triplem.insurancedataservice.imports.service.ImportProcessService;
import org.triplem.insurancedataservice.imports.util.ImportData;
import org.triplem.insurancedataservice.imports.util.ProcessStatus;
import org.triplem.insurancedataservice.util.exception.ProcessException;
import org.triplem.insurancedataservice.util.exception.ProcessRunningException;

public class ProcessStarterImpl implements ProcessStarter {

    private boolean isRunning = false;
    private ImportData importData;
    private final ImportProcessService importProcessService;

    public ProcessStarterImpl (ImportProcessService importProcessService) {
        this.importProcessService = importProcessService;
    }

    @Override
    public ProcessStatus startProcess(ImportData importData) throws ProcessRunningException, ProcessException {

        ProcessStatus processStatus = ProcessStatus.STARTED;

        if(isRunning) {
            throw new ProcessRunningException(this.importData);
        } else {
            isRunning = true;
            this.importData = importData;
            Thread importProcess = new Thread(() -> startProcessWhenNotRunning(importData));
            importProcess.setPriority(8);
            importProcess.start();
        }

        return processStatus;
    }

    private void startProcessWhenNotRunning(ImportData importData) {

        try {
            importProcessService.startImport(importData.importContent(), importData.tableName());
            isRunning = false;

        } catch (Exception ex) {
            isRunning = false;
            throw new ProcessException(ex.getMessage());
        }
    }
}
