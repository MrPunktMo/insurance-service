package org.triplem.insurancedataservice.data.factor.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.factor.model.FactorVehicleTypeDAO;
import org.triplem.insurancedataservice.models.FactorVehicleType;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T16:24:12+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class FactorVehicleTypeMapperImpl implements FactorVehicleTypeMapper {

    @Override
    public FactorVehicleType toFactorVehicleType(FactorVehicleTypeDAO factorVehicleTypeDAO) {
        if ( factorVehicleTypeDAO == null ) {
            return null;
        }

        FactorVehicleType factorVehicleType = new FactorVehicleType();

        factorVehicleType.setId( factorVehicleTypeDAO.getTypeId() );
        factorVehicleType.setType( factorVehicleTypeDAO.getType() );
        factorVehicleType.setFactor( factorVehicleTypeDAO.getFactor() );

        return factorVehicleType;
    }

    @Override
    public List<FactorVehicleType> toFactorVehicleTypes(List<FactorVehicleTypeDAO> factorVehicleTypeDAOs) {
        if ( factorVehicleTypeDAOs == null ) {
            return null;
        }

        List<FactorVehicleType> list = new ArrayList<FactorVehicleType>( factorVehicleTypeDAOs.size() );
        for ( FactorVehicleTypeDAO factorVehicleTypeDAO : factorVehicleTypeDAOs ) {
            list.add( toFactorVehicleType( factorVehicleTypeDAO ) );
        }

        return list;
    }
}
