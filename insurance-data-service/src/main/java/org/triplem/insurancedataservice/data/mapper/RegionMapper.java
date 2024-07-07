package org.triplem.insurancedataservice.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.region.model.RegionDAO;
import org.triplem.insurancedataservice.models.Region;

import java.util.List;

@Mapper
public interface RegionMapper {

    RegionMapper MAPPER = Mappers.getMapper(RegionMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "bundesLand")
    @Mapping(target = "postalCode", source = "postleitzahl")
    Region toRegion(RegionDAO regionDAO);

    List<Region> toRegions(List<RegionDAO> regionDAOs);

}
