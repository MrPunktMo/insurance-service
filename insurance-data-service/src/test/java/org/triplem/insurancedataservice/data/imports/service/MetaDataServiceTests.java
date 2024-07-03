package org.triplem.insurancedataservice.data.imports.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.triplem.insurancedataservice.data.imports.repository.AllTabColumnRepository;
import org.triplem.insurancedataservice.imports.wrapper.Table;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MetaDataServiceTests {

    @Autowired
    MetaDataService metaDataService;

    @Autowired
    AllTabColumnRepository allTabColumnRepository;

    String tableName;

    @BeforeEach
    void init() {
        tableName = allTabColumnRepository.findAll(Pageable.ofSize(20)).stream().findFirst().orElseThrow().getTableName();
    }

    @Test
    @DisplayName("Get all meta data mapped to wrapper")
    void getAllMetaDataMappedToWrapper() {
        Table table = metaDataService.getMetaDataOfDatabaseTable(tableName);
        assertNotNull(table);
        assertNotNull(table.getName());
        assertNotNull(table.getColumns());
    }

}
