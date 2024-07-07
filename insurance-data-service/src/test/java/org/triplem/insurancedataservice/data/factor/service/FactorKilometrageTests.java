package org.triplem.insurancedataservice.data.factor.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.triplem.insurancedataservice.models.FactorKilometrage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FactorKilometrageTests {

    @Autowired
    FactorKilometrageService factorKilometrageService;

    @Test
    @DisplayName("Get all valid kilometrages from db")
    void testGetAllValidKilometragesFromDb() {
        List<FactorKilometrage> factorKilometrages = factorKilometrageService.getKilometrages();
        assertNotNull(factorKilometrages);
        assertFalse(factorKilometrages.isEmpty());
    }

}
