package org.triplem.insurancedataservice.imports.components.starter;

import org.triplem.insurancedataservice.imports.util.ImportData;
import org.triplem.insurancedataservice.imports.util.ProcessStatus;
import org.triplem.insurancedataservice.util.exception.ProcessException;
import org.triplem.insurancedataservice.util.exception.ProcessRunningException;

public interface ProcessStarter {

    ProcessStatus startProcess(ImportData processData) throws ProcessRunningException, ProcessException;

}
