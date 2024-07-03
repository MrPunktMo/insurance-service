package org.triplem.insurancedataservice.imports.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.imports.components.ConfigHandlerProxy;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;
import org.triplem.insurancedataservice.imports.wrapper.Table;
import org.triplem.insurancedataservice.util.exception.ImportException;
import org.triplem.insurancedataservice.util.logging.Logging;

import java.io.File;

import java.sql.SQLException;

/**
 * @author M. Mirbach
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Setter
public class ImportProcessService {

	private final ConfigHandlerProxy configHandler;
	private final ImportProcessor importProcessor;

	private File importFile;
	private String tableName;

	public void startImport() {
		try {
			boolean isImported = importProcess();
			if(!isImported)
				throw new ImportException(Logging.PROCESS_ERROR.toString().replace("{}", "Unsuccessfull import"));
		} catch (ImportException | SQLException e) {
			throw new ImportException(e.getMessage());
		}
	}

	private boolean importProcess() throws ImportException, SQLException {

		log.info(Logging.FUNCTION_START.toString(), "Import process");

		/*get the table with all meta data*/
		Table table = configHandler.getTableWithMetaData(tableName);

		/*get the data of the import file*/
		ImportData importData = configHandler.getImportData(table, importFile);

		/*import the data*/
		importProcessor.process(importData);

		log.info(Logging.FUNCTION_END.toString(), "Import process");

		return true;
	}

}