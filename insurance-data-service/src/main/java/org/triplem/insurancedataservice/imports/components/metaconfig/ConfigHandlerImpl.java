package org.triplem.insurancedataservice.imports.components.metaconfig;

import lombok.AllArgsConstructor;
import org.triplem.insurancedataservice.data.imports.service.MetaDataService;
import org.triplem.insurancedataservice.imports.wrapper.ImportData;
import org.triplem.insurancedataservice.imports.wrapper.Table;
import org.triplem.insurancedataservice.util.exception.ImportException;
import org.triplem.insurancedataservice.util.file.FileService;
import org.triplem.insurancedataservice.util.logging.Logging;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ConfigHandlerImpl implements ConfigHandler {

	private final FileService fileService;
	private final MetaDataService metaDataService;

	@Override
	public Table getTableWithMetaData(String tableName) {
		return metaDataService.getMetaDataOfDatabaseTable(tableName);
	}

	@Override
	public ImportData getImportData(Table table, File importFile)
	{
		ImportData importData;

		String[] fileContent = fileService.getAllLinesFromFile(importFile, false, fileService.getFileEncodingForImport(importFile));

		if(fileContent != null && fileContent.length > 0) { /*Otherwise there was an error in the reading the file and this file will not be processed*/
			importData = new ImportData();
			importData.setValues(mapFileContentToValuesMap(fileContent));
			importData.setTable(table);
			setAmountOfImportData(importData);

		} else {
			/*There was an error in the file in example the reading returned a null-content or the amount of lines was zero so move this file into the error directory*/
			throw new ImportException(String.format(Logging.FILE_CONTENT_EMPTY.toString(), importFile.getName()));
		}

		return importData;
	}

	private void setAmountOfImportData(ImportData importData) {

		if(importData.getValues() != null && importData.getValues().values().stream().findFirst().isPresent()) {
			importData.setImportAmount((long) importData.getValues().values().stream().findFirst().get().size());
		} else {
			importData.setImportAmount(0L);
		}
	}

	private Map<String, List<String>> mapFileContentToValuesMap(String[] fileContent) {

		Map<String, List<String>> values = new HashMap<>();
		List<String> headerLine = Arrays.stream(fileContent[0].split(";")).map(String::toUpperCase).toList();
		final List<List<String>> valueLines = new ArrayList<>();

		Arrays.stream(fileContent).skip(1).forEach( (line) -> valueLines.add(Arrays.stream(line.split(";", -1)).collect(Collectors.toList())));

		/*check whether all the values are correct size*/
		checkValuesForValidity(headerLine, valueLines);

		headerLine.forEach(attribute -> {
			int indexOfAttribute = headerLine.indexOf(attribute);
			List<String> attributeValues = new ArrayList<>();
			valueLines.forEach(valueLine -> attributeValues.add(valueLine.get(indexOfAttribute)));
			values.put(attribute, attributeValues);
		});

		return values;
	}

	private void checkValuesForValidity(List<String> header, List<List<String>> values) {
		int headerSize = header.size();

		List<List<String>> invalidValues = values.stream().filter(value -> value.size() != headerSize).toList();

		if(!invalidValues.isEmpty()) {
			String errorMessage = getFormattedInvalidLines(invalidValues);
			throw new ImportException(String.format(Logging.VALUES_INVALID_ERROR.getMessage(), errorMessage));
		}

	}

	private String getFormattedInvalidLines(List<List<String>> invalidLines) {

		StringBuilder errorLineBuilder = new StringBuilder();

		errorLineBuilder.append("\n");
		invalidLines.forEach(invalidLine -> {
			int lastValueIndex = 0;
			for(String value : invalidLine) {

				errorLineBuilder.append(value);

				lastValueIndex++;
				if(lastValueIndex < invalidLine.size())
					errorLineBuilder.append(";");
				else
					errorLineBuilder.append("\n");
			}
		});

		return errorLineBuilder.toString();

	}

}
