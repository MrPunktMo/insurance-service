package org.triplem.insurancedataservice.data.factor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.triplem.insurancedataservice.data.factor.model.FactorVehicleTypeDAO;

import java.time.LocalDate;
import java.util.List;

public interface FactorVehicleTypeRepository extends JpaRepository<FactorVehicleTypeDAO, Integer> {

    default List<FactorVehicleTypeDAO> getValidVehiclyTypes() {
        return getAllValid(LocalDate.now());
    }

    @Query("select f from FactorVehicleTypeDAO f where ?1 between f.validFrom and f.validTo")
    List<FactorVehicleTypeDAO> getAllValid(LocalDate compareDate);

}
