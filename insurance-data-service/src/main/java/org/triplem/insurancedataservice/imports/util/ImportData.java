package org.triplem.insurancedataservice.imports.util;

public record ImportData(
        String tableName, byte[] importContent
) {

}
