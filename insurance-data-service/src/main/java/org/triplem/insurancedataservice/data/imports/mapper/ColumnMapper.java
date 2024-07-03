package org.triplem.insurancedataservice.data.imports.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.imports.model.AllTabColumnDAO;
import org.triplem.insurancedataservice.imports.wrapper.Column;

@Mapper
public interface ColumnMapper {

    ColumnMapper MAPPER = Mappers.getMapper(ColumnMapper.class);

    @Mapping(source = "columnName", target = "name")
    Column toColumn(AllTabColumnDAO allTabColumnDAO);

    default boolean stringToBoolean(String identity) {
        return identity != null && (!identity.equals("NO"));
    }

}
