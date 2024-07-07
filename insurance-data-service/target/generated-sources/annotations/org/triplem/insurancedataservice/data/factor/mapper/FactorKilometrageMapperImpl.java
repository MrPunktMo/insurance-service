package org.triplem.insurancedataservice.data.factor.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.factor.model.FactorKilometrageDAO;
import org.triplem.insurancedataservice.models.FactorKilometrage;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T16:24:13+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class FactorKilometrageMapperImpl implements FactorKilometrageMapper {

    @Override
    public FactorKilometrage toFactorKilometrage(FactorKilometrageDAO factorKilometrageDAO) {
        if ( factorKilometrageDAO == null ) {
            return null;
        }

        FactorKilometrage factorKilometrage = new FactorKilometrage();

        factorKilometrage.setId( factorKilometrageDAO.getKilometerID() );
        factorKilometrage.setFrom( factorKilometrageDAO.getFrom() );
        factorKilometrage.setTo( factorKilometrageDAO.getTo() );
        factorKilometrage.setFactor( factorKilometrageDAO.getFactor() );

        return factorKilometrage;
    }

    @Override
    public List<FactorKilometrage> toFactorKilometrages(List<FactorKilometrageDAO> factorKilometrageDAOs) {
        if ( factorKilometrageDAOs == null ) {
            return null;
        }

        List<FactorKilometrage> list = new ArrayList<FactorKilometrage>( factorKilometrageDAOs.size() );
        for ( FactorKilometrageDAO factorKilometrageDAO : factorKilometrageDAOs ) {
            list.add( toFactorKilometrage( factorKilometrageDAO ) );
        }

        return list;
    }
}
