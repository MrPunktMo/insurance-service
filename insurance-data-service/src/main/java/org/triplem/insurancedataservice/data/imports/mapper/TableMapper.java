package org.triplem.insurancedataservice.data.imports.mapper;

import jakarta.validation.constraints.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.imports.model.AllTabColumnDAO;
import org.triplem.insurancedataservice.imports.wrapper.Column;
import org.triplem.insurancedataservice.imports.wrapper.Table;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = ColumnMapper.class)
public interface TableMapper {

    TableMapper MAPPER = Mappers.getMapper(TableMapper.class);

    default Table toTable(@NotNull List<AllTabColumnDAO> allTabColumnDAOs) {
        Table table = null;

        if(allTabColumnDAOs.stream().findFirst().isPresent()) {

            AllTabColumnDAO allTabColumnDAO = allTabColumnDAOs.stream().findFirst().get();
            table = new Table();
            table.setName(allTabColumnDAO.getTableName());

            final List<Column> columns = new ArrayList<>();

            allTabColumnDAOs.forEach(tableColumnDAO -> {
                columns.add(ColumnMapper.MAPPER.toColumn(tableColumnDAO));
            });

            table.setColumns(columns);
        }
        return table;
    }

}
