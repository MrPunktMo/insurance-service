package org.triplem.insurancedataservice.imports.wrapper;

/**
 * Column object as a representation of a database column
 */

public record Column(String name, String dataType) {

    @Override
    public String toString() {
        return "class Column {\n" +
                "    name: " + toIndentedString(name) + "\n" +
                "    dataType: " + toIndentedString(dataType) + "\n" +
                "}";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}