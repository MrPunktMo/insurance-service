package org.triplem.insurancedataservice.imports.components.starter;


import lombok.extern.slf4j.Slf4j;
import org.triplem.insurancedataservice.imports.service.ImportProcessService;
import org.triplem.insurancedataservice.imports.util.ImportData;
import org.triplem.insurancedataservice.imports.util.ProcessStatus;
import org.triplem.insurancedataservice.util.exception.ProcessRunningException;

@Slf4j
public class ProcessStarterProxy implements ProcessStarter {

    private final ProcessStarterImpl target;
    private static final String START_PROCESS = "Import %s started";
    private static final String RUNNING_PROCESS = "Import %s can't be started as %s is already running";
    private static final String FAILED_PROCESS = "Import %s failed caused by: %s";

    public ProcessStarterProxy(ImportProcessService importProcessService) {
        this.target = new ProcessStarterImpl(importProcessService);
    }

    @Override
    public ProcessStatus startProcess(ImportData importData) {

        ProcessStatus processStatus = ProcessStatus.STARTED;

        try {
            log.info(String.format(START_PROCESS, importData.tableName()));
            processStatus = this.target.startProcess(importData);
        } catch (ProcessRunningException processRunningException) {
            log.info(String.format(RUNNING_PROCESS, importData.tableName(), processRunningException.getImportData().tableName()));
            processStatus = ProcessStatus.RUNNING;
        } catch (Exception ex) {
            log.error(String.format(FAILED_PROCESS, importData.tableName(), ex.getMessage()));
        }

        return processStatus;

    }
}
