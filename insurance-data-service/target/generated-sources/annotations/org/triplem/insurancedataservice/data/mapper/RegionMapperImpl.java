package org.triplem.insurancedataservice.data.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.region.model.RegionDAO;
import org.triplem.insurancedataservice.models.Region;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T16:24:13+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class RegionMapperImpl implements RegionMapper {

    @Override
    public Region toRegion(RegionDAO regionDAO) {
        if ( regionDAO == null ) {
            return null;
        }

        Region region = new Region();

        region.setName( regionDAO.getBundesLand() );
        region.setPostalCode( regionDAO.getPostleitzahl() );

        return region;
    }

    @Override
    public List<Region> toRegions(List<RegionDAO> regionDAOs) {
        if ( regionDAOs == null ) {
            return null;
        }

        List<Region> list = new ArrayList<Region>( regionDAOs.size() );
        for ( RegionDAO regionDAO : regionDAOs ) {
            list.add( toRegion( regionDAO ) );
        }

        return list;
    }
}
