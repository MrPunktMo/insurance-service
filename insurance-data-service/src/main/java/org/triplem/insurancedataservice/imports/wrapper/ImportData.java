package org.triplem.insurancedataservice.imports.wrapper;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import jakarta.annotation.Generated;

/**
 * Import data object with the table to insert and the values
 */

@Schema(name = "ImportData", description = "Import data object with the table to insert and the values")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-02T15:21:00.919889800+02:00[Europe/Berlin]")
public class ImportData {

    @JsonProperty("table")
    private Table table;

    @JsonProperty("importId")
    private Long importId;

    @JsonProperty("importAmount")
    private Long importAmount;

    @JsonProperty("values")
    @Valid
    private Map<String, List<String>> values = new HashMap<>();

    public ImportData table(Table table) {
        this.table = table;
        return this;
    }

    /**
     * Get table
     * @return table
     */
    @NotNull @Valid
    @Schema(name = "table", requiredMode = Schema.RequiredMode.REQUIRED)
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public ImportData importId(Long importId) {
        this.importId = importId;
        return this;
    }

    /**
     * Get importId
     * @return importId
     */
    @NotNull
    @Schema(name = "importId", requiredMode = Schema.RequiredMode.REQUIRED)
    public Long getImportId() {
        return importId;
    }

    public void setImportId(Long importId) {
        this.importId = importId;
    }

    public ImportData importAmount(Long importAmount) {
        this.importAmount = importAmount;
        return this;
    }

    /**
     * Get importAmount
     * @return importAmount
     */

    @Schema(name = "importAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public Long getImportAmount() {
        return importAmount;
    }

    public void setImportAmount(Long importAmount) {
        this.importAmount = importAmount;
    }

    public ImportData values(Map<String, List<String>> values) {
        this.values = values;
        return this;
    }

    public ImportData putValuesItem(String key, List<String> valuesItem) {
        this.values.put(key, valuesItem);
        return this;
    }

    /**
     * Get values
     * @return values
     */
    @NotNull @Valid
    @Schema(name = "values", requiredMode = Schema.RequiredMode.REQUIRED)
    public Map<String, List<String>> getValues() {
        return values;
    }

    public void setValues(Map<String, List<String>> values) {
        this.values = values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImportData importData = (ImportData) o;
        return Objects.equals(this.table, importData.table) &&
                Objects.equals(this.importId, importData.importId) &&
                Objects.equals(this.importAmount, importData.importAmount) &&
                Objects.equals(this.values, importData.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(table, importId, importAmount, values);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImportData {\n");
        sb.append("    table: ").append(toIndentedString(table)).append("\n");
        sb.append("    importId: ").append(toIndentedString(importId)).append("\n");
        sb.append("    importAmount: ").append(toIndentedString(importAmount)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
        sb.append("}");
        return sb.toString();
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
