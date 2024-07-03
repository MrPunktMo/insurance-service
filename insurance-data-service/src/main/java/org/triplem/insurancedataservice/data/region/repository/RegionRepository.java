package org.triplem.insurancedataservice.data.region.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.triplem.insurancedataservice.data.region.model.RegionDAO;
import org.triplem.insurancedataservice.data.region.model.RegionPK;

public interface RegionRepository extends JpaRepository<RegionDAO, RegionPK> {

    @Modifying
    @Query(value = "truncate table region", nativeQuery = true)
    @Transactional
    void truncate();

}
