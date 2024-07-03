package org.triplem.insurancedataservice.util.logging;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Logging {

    /*infos*/
    PROCESS_START("0001", "Process was started"),
    PROCESS_END("0002", "Process ended"),
    FUNCTION_START("0003", "Start function {}"),
    FUNCTION_END("0004", "End function {}"),
    FILES_FOUND("0005", "Table: {} - found: {} file/s."),
    LINES_INVESTIGATED("0006", "Trace: {}"),
    PROCESSING_TABLE_START("0007", "Process table {} start"),
    PROCESSING_TABLE_PARTLY("0008", "Partly process table: {}"),
    PROCESSING_TABLE_END("0009", "Process table {} ended"),
    FILE_ENCODING("0010", "Following file encoding was detected: {}"),
    IMPORTED_DATA("0011", "Page {} was post processed"),
    FILE_ALREADY_UPLOADED("0100", "File with id {} was already uploaded."),

    /*warning*/
    FILE_ENCODING_WARNING("8000", "Default file encoding {} will be used"),
    LOG_FILE_WARNING("8001", "Status log could not be created")

    /*errors*/,
    PROCESS_ERROR("9000", "Process closed with error: {}"),
    LOGGING_PROPERTIES_ERROR("9001", "Logging properties could not be loaded"),
    ERROR_COUNT("9002", "{} line/s was/were written to the error file."),
    IMPORT_TYPE_ERROR("9004", "The import type {} of the file is not configured in the configuration table."),
    CHECK_LOG_DB_ERROR("9005", "Error checking log DB for file {}."),
    RECORD_NOT_FOUND_ERROR("9006", "{} was not found in table {}."),
    META_DATA_LOAD_ERROR("9007", "{} meta-data could not be load. Table won't be processed."),
    FILE_ATTRIBUTES_ERROR("9008", "Found errors in {} file/s. Check the error-log for more information."),
    INSERT_UPDATE_ERROR("9009", "Failed to insert/update line: '{}' into table: {}. Reason: {}."),
    WRITE_DB_CONNECTION_ERROR("9010", "Writer-connection to database failed."),
    UPDATE_AUDIT_ERROR("9011", "Error updating audit log table: '{}'."),
    DUPLICATE_FILE_ERROR("9012", "Duplicate file: {}! File was already processed."),
    FILE_MISSING_ERROR("9013", "File '{}' does not exist."),
    INVALID_DIRECTORY_ERROR("9014", "Invalid directory: {}!"),
    PERMISSION_DIRECTORY_ERROR("9015", "Can not access directory '{}'. Check read/write permissions."),
    FILE_CONTENT_ERROR("9016", "Found errors in {} file/s. Check the error-log for more information."),
    FILE_CANNOT_BE_MOVED_ERROR("9017", "Cannot move file '{}' to directory '{}'."),
    WRITING_FILE_ERROR("9018", "An error occurred while writing the file: {}."),
    FILE_PATTERN_ERROR("9019", "File pattern of '{}' does not match given file pattern."),
    FILE_READING_ERROR("9020", "Exception occurred while reading the file! Check the file: '{}'."),
    FILE_ENCODING_ERROR("9021", "Determining file encoding threw exception: {}"),
    FILE_CONTENT_EMPTY("9022", "File content of file {} was empty."),
    FILE_DUPLICATE_PROCESSED("9023", "File {} is duplicate in processed directory. Will be moved to error directory"),
    FILE_DUPLICATE_ERROR("9024", "File {} is duplicate in error directory. Process is stopped"),
    DIRECTORIES_NOT_INITIALIZED("9025", "Directories were not been initialized. Check directories."),
    LIMIT_NOT_SET_CORRECTLY("9026", "Limit to get database data was not set correctly"),
    FILES_NOT_READABLE("9027", "Could not read files from path: {}"),
    VALUES_INVALID_ERROR("9028", "Following lines were invalid: %s"),
    NO_POST_PROCESSOR_FOUND("9029", "No post processor found for import type %s")
    ;

    private final String key;
    private final String message;

    @Override
    public String toString() {
        return key + ": " + message;
    }

    public static boolean hasKey(String key) {
        return Arrays.stream(Logging.values()).anyMatch(logging -> logging.key.equals(key));
    }

}
