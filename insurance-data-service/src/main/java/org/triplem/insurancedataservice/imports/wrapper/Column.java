package org.triplem.insurancedataservice.imports.wrapper;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Column object as a representation of a data base column
 */

@Schema(name = "Column", description = "Column object as a representation of a data base column")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-02T15:21:00.919889800+02:00[Europe/Berlin]")
public class Column {

    @JsonProperty("name")
    private String name;

    @JsonProperty("dataType")
    private String dataType;

    @JsonProperty("identity")
    private Boolean identity;

    public Column name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     */
    @NotNull
    @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Column dataType(String dataType) {
        this.dataType = dataType;
        return this;
    }

    /**
     * Get dataType
     * @return dataType
     */
    @NotNull
    @Schema(name = "dataType", requiredMode = Schema.RequiredMode.REQUIRED)
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Column identity(Boolean identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get identity
     * @return identity
     */

    @Schema(name = "identity", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public Boolean getIdentity() {
        return identity;
    }

    public void setIdentity(Boolean identity) {
        this.identity = identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Column column = (Column) o;
        return Objects.equals(this.name, column.name) &&
                Objects.equals(this.dataType, column.dataType) &&
                Objects.equals(this.identity, column.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataType, identity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Column {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
        sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
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