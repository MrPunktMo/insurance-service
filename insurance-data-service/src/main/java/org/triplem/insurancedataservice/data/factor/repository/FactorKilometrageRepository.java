package org.triplem.insurancedataservice.data.factor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.triplem.insurancedataservice.data.factor.model.FactorKilometrageDAO;

import java.time.LocalDate;
import java.util.List;

public interface FactorKilometrageRepository extends JpaRepository<FactorKilometrageDAO, Integer> {

    default List<FactorKilometrageDAO> getValidKilometrages() {
        return getAllValid(LocalDate.now());
    }

    @Query("select f from FactorKilometrageDAO f where ?1 between f.validFrom and f.validTo")
    List<FactorKilometrageDAO> getAllValid(LocalDate compareDate);

}
