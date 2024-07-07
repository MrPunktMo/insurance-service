package org.triplem.insurancedataservice.data.factor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.factor.model.FactorKilometrageDAO;
import org.triplem.insurancedataservice.models.FactorKilometrage;

import java.util.List;

@Mapper
public interface FactorKilometrageMapper {

    FactorKilometrageMapper MAPPER = Mappers.getMapper(FactorKilometrageMapper.class);

    @Mapping(target = "id", source = "kilometerID")
    FactorKilometrage toFactorKilometrage(FactorKilometrageDAO factorKilometrageDAO);

    List<FactorKilometrage> toFactorKilometrages(List<FactorKilometrageDAO> factorKilometrageDAOs);

}
