package org.triplem.insurancedataservice.data.factor.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.triplem.insurancedataservice.data.factor.model.FeeDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ExtendWith(SpringExtension.class)
class FeeRepositoryTests {

    @Autowired
    private FeeRepository feeRepository;

    @Test
    @Transactional
    @DisplayName("Save a Fee in the db")
    void testSaveFeeInDatabase() {

        FeeDAO toBeSaved = new FeeDAO();
        toBeSaved.setAmount(150.09f);
        toBeSaved.setVehicleType("Test Vehicle Type");
        toBeSaved.setKilometrage(10000);
        toBeSaved.setPostalCode("12345");
        toBeSaved.setCreatedBy("Test User");

        FeeDAO savedFee = feeRepository.save(toBeSaved);
        assertNotNull(savedFee);
        assertEquals(toBeSaved.getAmount(), savedFee.getAmount());
        assertEquals(toBeSaved.getVehicleType(), savedFee.getVehicleType());
        assertNotNull(toBeSaved.getCreatedOn());

    }

}
