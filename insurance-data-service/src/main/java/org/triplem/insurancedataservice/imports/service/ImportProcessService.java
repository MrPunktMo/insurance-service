package org.triplem.insurancedataservice.imports.service;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.imports.components.metaconfig.ConfigHandlerProxy;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;
import org.triplem.insurancedataservice.imports.wrapper.Table;
import org.triplem.insurancedataservice.util.exception.ImportException;
import org.triplem.insurancedataservice.util.file.FileService;
import org.triplem.insurancedataservice.util.logging.Logging;

import java.io.File;

import java.io.IOException;
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
	private final FileService fileService;

	public boolean startImport(byte[] importFileContent, String tableName) {

		try {

			File importFile = fileService.createTemporaryFile(importFileContent, tableName, "csv");

			boolean isImported = importProcess(importFile, tableName);

			if (!isImported)
				throw new ImportException(Logging.PROCESS_ERROR.toString().replace("{}", "Unsuccessfull import"));

			return true;
		} catch (IOException ex) {
			throw new ImportException("Could not create temporary file with given input");
		} catch (ImportException | SQLException e) {
			throw new ImportException(e.getMessage());
		}
	}

	private boolean importProcess(File importFile, String tableName) throws ImportException, SQLException {

		log.info(Logging.FUNCTION_START.toString(), "Import process");

		/*get the table with all meta data*/
		Table table = configHandler.getTableWithMetaData(tableName);

		/*get the data of the import file*/
		ImportData importData = configHandler.getImportData(table, importFile);

		/*import the data*/
		boolean isImportSuccessfull = importProcessor.process(importData);

		log.info(Logging.FUNCTION_END.toString(), "Import process");

		return isImportSuccessfull;
	}



}