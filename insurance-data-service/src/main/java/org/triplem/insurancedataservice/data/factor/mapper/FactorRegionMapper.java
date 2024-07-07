package org.triplem.insurancedataservice.data.factor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.factor.model.FactorRegionDAO;
import org.triplem.insurancedataservice.models.FactorRegion;

import java.util.List;

@Mapper
public interface FactorRegionMapper {

    FactorRegionMapper MAPPER = Mappers.getMapper(FactorRegionMapper.class);

    @Mapping(target = "id", source = "regionId")
    FactorRegion toFactorRegion(FactorRegionDAO factorRegionDAO);

    List<FactorRegion> toFactorRegions(List<FactorRegionDAO> factorRegionDAOs);

}
