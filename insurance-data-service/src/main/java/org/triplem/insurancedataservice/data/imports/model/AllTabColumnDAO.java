package org.triplem.insurancedataservice.data.imports.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "all_tab_columns")
@IdClass(AllTabColumnPK.class)
@Getter
@Setter
public class AllTabColumnDAO {

    @Id
    @Column(name = "database_schema")
    private String databaseSchema;

    @Id
    @Column(name = "table_name")
    private String tableName;

    @Id
    @Column(name = "column_name")
    private String columnName;

    @Column(name = "data_type")
    private String dataType;

}
