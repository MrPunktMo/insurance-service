package org.triplem.insurancedataservice.data.imports.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@Data
public class AllTabColumnPK implements Serializable {

    private String databaseSchema;
    private String tableName;
    private String columnName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllTabColumnPK that = (AllTabColumnPK) o;
        return Objects.equals(databaseSchema, that.databaseSchema) && Objects.equals(tableName, that.tableName) && Objects.equals(columnName, that.columnName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(databaseSchema, tableName, columnName);
    }

}
