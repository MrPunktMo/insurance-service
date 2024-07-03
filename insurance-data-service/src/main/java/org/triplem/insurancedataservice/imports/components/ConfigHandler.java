/**
 * 
 */
package org.triplem.insurancedataservice.imports.components;


import org.triplem.insurancedataservice.imports.wrapper.ImportData;
import org.triplem.insurancedataservice.imports.wrapper.Table;

import java.io.File;

public interface ConfigHandler {
	
	/**
	 * Get the meta data of the table to load form
	 * @param tableName
	 * @return
	 */
	Table getTableWithMetaData(String tableName);

	/**
	 * Get the table for the given file
	 * @param table
	 * @param inFile
	 * @return ImportData - data with the file
	 */
	ImportData getImportData(Table table, File inFile);

}


