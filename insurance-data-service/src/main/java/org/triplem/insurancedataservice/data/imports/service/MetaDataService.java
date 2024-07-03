package org.triplem.insurancedataservice.data.imports.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.imports.mapper.TableMapper;
import org.triplem.insurancedataservice.data.imports.repository.AllTabColumnRepository;
import org.triplem.insurancedataservice.imports.wrapper.Table;

@AllArgsConstructor
@Service
public class MetaDataService {

    AllTabColumnRepository allTabColumnRepository;

    public Table getMetaDataOfDatabaseTable(String tableName) {
        return TableMapper.MAPPER.toTable(allTabColumnRepository.findAllTabColumnDAOByTableName(tableName));
    }

}
