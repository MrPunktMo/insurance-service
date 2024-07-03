package org.triplem.insurancedataservice.data.imports.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.triplem.insurancedataservice.data.imports.model.AllTabColumnDAO;
import org.triplem.insurancedataservice.data.imports.model.AllTabColumnPK;

import java.util.List;

public interface AllTabColumnRepository extends JpaRepository<AllTabColumnDAO, AllTabColumnPK> {

    List<AllTabColumnDAO> findAllTabColumnDAOByTableName(String tableName);

}
