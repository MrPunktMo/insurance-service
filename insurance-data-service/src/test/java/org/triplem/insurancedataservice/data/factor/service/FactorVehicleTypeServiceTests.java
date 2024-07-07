package org.triplem.insurancedataservice.data.factor.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.triplem.insurancedataservice.models.FactorVehicleType;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class FactorVehicleTypeServiceTests {

    @Autowired
    FactorVehicleTypeService vehicleTypeService;

    @Test
    @DisplayName("Get all valid vehicle types from db")
    void getAllFactorVehicleTypesFromDb() {
        List<FactorVehicleType> vehicleTypes = vehicleTypeService.getFactorVehicleTypes();
        assertNotNull(vehicleTypes);
        assertFalse(vehicleTypes.isEmpty());
    }

}
