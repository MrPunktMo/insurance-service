package org.triplem.insurancedataservice.data.factor.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.factor.model.FactorRegionDAO;
import org.triplem.insurancedataservice.models.FactorRegion;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T16:24:13+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class FactorRegionMapperImpl implements FactorRegionMapper {

    @Override
    public FactorRegion toFactorRegion(FactorRegionDAO factorRegionDAO) {
        if ( factorRegionDAO == null ) {
            return null;
        }

        FactorRegion factorRegion = new FactorRegion();

        factorRegion.setId( factorRegionDAO.getRegionId() );
        factorRegion.setRegion( factorRegionDAO.getRegion() );
        factorRegion.setFactor( factorRegionDAO.getFactor() );

        return factorRegion;
    }

    @Override
    public List<FactorRegion> toFactorRegions(List<FactorRegionDAO> factorRegionDAOs) {
        if ( factorRegionDAOs == null ) {
            return null;
        }

        List<FactorRegion> list = new ArrayList<FactorRegion>( factorRegionDAOs.size() );
        for ( FactorRegionDAO factorRegionDAO : factorRegionDAOs ) {
            list.add( toFactorRegion( factorRegionDAO ) );
        }

        return list;
    }
}
