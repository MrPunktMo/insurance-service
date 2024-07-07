package org.triplem.insurancedataservice.data.factor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.triplem.insurancedataservice.data.factor.model.FeeDAO;

import java.util.List;

public interface FeeRepository extends JpaRepository<FeeDAO, Integer> {

    List<FeeDAO> findAllByCreatedBy(String createdBy);

}
