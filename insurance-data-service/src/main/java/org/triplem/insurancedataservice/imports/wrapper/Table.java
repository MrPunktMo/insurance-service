package org.triplem.insurancedataservice.imports.wrapper;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Table object as a representation of a data base table
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Table {

    private String name;
    private List<Column> columns;

}

