package org.triplem.insurancedataservice.data.factor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.triplem.insurancedataservice.data.factor.model.FactorRegionDAO;

import java.time.LocalDate;
import java.util.List;

public interface FactorRegionRepository extends JpaRepository<FactorRegionDAO, Integer> {

    default List<FactorRegionDAO> getValidRegions() {
        return getAllValid(LocalDate.now());
    }

    @Query("select f from FactorRegionDAO f where ?1 between f.validFrom and f.validTo")
    List<FactorRegionDAO> getAllValid(LocalDate compareDate);


}
