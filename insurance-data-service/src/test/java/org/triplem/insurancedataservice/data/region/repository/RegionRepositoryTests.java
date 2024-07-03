package org.triplem.insurancedataservice.data.region.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.triplem.insurancedataservice.data.region.model.RegionDAO;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class RegionRepositoryTests {

    @Autowired
    RegionRepository regionRepository;

    @Test
    @DisplayName("Get all regions from db")
    void testGetAllRegions() {
        assertDoesNotThrow(() -> regionRepository.findAll());
    }

    @Test
    @DisplayName("Save region in db")
    @Transactional
    void testSaveRegion() {

        RegionDAO toBeSaved = new RegionDAO();
        toBeSaved.setOrt("Test Ort");
        toBeSaved.setLand("Test Land");
        toBeSaved.setStadt("Test Stadt");
        toBeSaved.setPostleitzahl("12345");
        toBeSaved.setBundesLand("Test Bundesland");

        RegionDAO savedRegionDAO = regionRepository.save(toBeSaved);
        assertNotNull(savedRegionDAO);
        assertEquals(toBeSaved.getBundesLand(), savedRegionDAO.getBundesLand());

    }

}
