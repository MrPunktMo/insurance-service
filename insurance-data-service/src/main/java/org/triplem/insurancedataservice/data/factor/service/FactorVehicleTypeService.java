package org.triplem.insurancedataservice.data.factor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.factor.mapper.FactorVehicleTypeMapper;
import org.triplem.insurancedataservice.data.factor.repository.FactorVehicleTypeRepository;
import org.triplem.insurancedataservice.models.FactorVehicleType;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactorVehicleTypeService {

    private final FactorVehicleTypeRepository vehicleTypeRepository;

    public List<FactorVehicleType> getFactorVehicleTypes() {
        return FactorVehicleTypeMapper.MAPPER.toFactorVehicleTypes(vehicleTypeRepository.getValidVehiclyTypes());
    }

}
