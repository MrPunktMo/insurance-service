package org.triplem.insurancedataservice.data.factor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.factor.model.FactorVehicleTypeDAO;
import org.triplem.insurancedataservice.models.FactorVehicleType;

import java.util.List;

@Mapper
public interface FactorVehicleTypeMapper {

    FactorVehicleTypeMapper MAPPER = Mappers.getMapper(FactorVehicleTypeMapper.class);

    @Mapping(target = "id", source = "typeId")
    FactorVehicleType toFactorVehicleType(FactorVehicleTypeDAO factorVehicleTypeDAO);

    List<FactorVehicleType> toFactorVehicleTypes(List<FactorVehicleTypeDAO> factorVehicleTypeDAOs);

}
