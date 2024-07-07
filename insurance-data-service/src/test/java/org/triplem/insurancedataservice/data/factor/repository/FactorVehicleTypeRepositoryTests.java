package org.triplem.insurancedataservice.data.factor.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.triplem.insurancedataservice.data.factor.model.FactorVehicleTypeDAO;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
public class FactorVehicleTypeRepositoryTests {

    @Autowired
    private FactorVehicleTypeRepository factorVehicleTypeRepository;

    @Test
    @DisplayName("Get all vehicle types form Db")
    void testGetAllFahrzeugypenFormDb() {
        assertDoesNotThrow(() -> factorVehicleTypeRepository.findAll());
    }

    @Test
    @DisplayName("Save a vehicle type in the db")
    void saveFahrzeugTyp() {

        FactorVehicleTypeDAO testFahrzeugTyp = new FactorVehicleTypeDAO();
        testFahrzeugTyp.setType("TesTyp");
        testFahrzeugTyp.setFactor(1.56f);
        testFahrzeugTyp.setValidFrom(LocalDate.now());
        testFahrzeugTyp.setValidTo(LocalDate.now().plusMonths(12));

        FactorVehicleTypeDAO savedFactorVehicleTypeDAO = factorVehicleTypeRepository.save(testFahrzeugTyp);
        assertNotNull(savedFactorVehicleTypeDAO);
        assertNotNull(savedFactorVehicleTypeDAO.getTypeId());
        assertEquals(testFahrzeugTyp.getType(), savedFactorVehicleTypeDAO.getType());

    }


}
