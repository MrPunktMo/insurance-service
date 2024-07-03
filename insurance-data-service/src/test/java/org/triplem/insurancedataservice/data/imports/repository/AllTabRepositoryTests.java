package org.triplem.insurancedataservice.data.imports.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.triplem.insurancedataservice.data.imports.model.AllTabColumnDAO;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class AllTabRepositoryTests {

    @Autowired
    AllTabColumnRepository allTabColumnRepository;

    @Test
    @DisplayName("Load all meta data from db")
    void testGetAllMetaDataFromTable() {

        List<AllTabColumnDAO> tables = allTabColumnRepository.findAll();
        assertNotNull(tables);

    }

}
