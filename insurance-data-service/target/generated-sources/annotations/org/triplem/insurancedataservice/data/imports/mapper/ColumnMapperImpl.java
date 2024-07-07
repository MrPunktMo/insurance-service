package org.triplem.insurancedataservice.data.imports.mapper;

import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.imports.model.AllTabColumnDAO;
import org.triplem.insurancedataservice.imports.wrapper.Column;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T16:24:13+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class ColumnMapperImpl implements ColumnMapper {

    @Override
    public Column toColumn(AllTabColumnDAO allTabColumnDAO) {
        if ( allTabColumnDAO == null ) {
            return null;
        }

        String name = null;
        String dataType = null;

        name = allTabColumnDAO.getColumnName();
        dataType = allTabColumnDAO.getDataType();

        Column column = new Column( name, dataType );

        return column;
    }
}
