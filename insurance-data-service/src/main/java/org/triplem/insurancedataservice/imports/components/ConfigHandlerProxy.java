
package org.triplem.insurancedataservice.imports.components;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;
import org.triplem.insurancedataservice.imports.wrapper.Table;
import org.triplem.insurancedataservice.util.logging.Logging;

import java.io.File;

@AllArgsConstructor
@Slf4j
public class ConfigHandlerProxy implements ConfigHandler {

	private final ConfigHandlerImpl target;

	@Override
	public Table getTableWithMetaData(String tableName) {

		log.info(Logging.FUNCTION_START.toString(), "Load meta data of table");

		Table tableWithMetaData = this.target.getTableWithMetaData(tableName);

		log.info(Logging.FUNCTION_END.toString(), "Load meta data of table");

		return tableWithMetaData;
	}
	
	@Override
	public ImportData getImportData(Table table, File importFile) {

		log.info(Logging.FUNCTION_START.toString(), "Get table list for file");

		ImportData importData = this.target.getImportData(table, importFile);
		
		log.info(Logging.FUNCTION_END.toString(), "Get table list for file");

		return importData;
		
	}

}
