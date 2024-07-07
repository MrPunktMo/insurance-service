package org.triplem.insurancedataservice.data.factor.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.factor.model.FeeDAO;
import org.triplem.insurancedataservice.models.Fee;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-07T16:24:13+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Azul Systems, Inc.)"
)
public class FeeMapperImpl implements FeeMapper {

    @Override
    public Fee toFee(FeeDAO feeDAO) {
        if ( feeDAO == null ) {
            return null;
        }

        Fee fee = new Fee();

        fee.setUser( feeDAO.getCreatedBy() );
        fee.setAmount( feeDAO.getAmount() );
        fee.setKilometrage( feeDAO.getKilometrage() );
        fee.setPostalCode( feeDAO.getPostalCode() );
        fee.setVehicleType( feeDAO.getVehicleType() );
        fee.setCreatedOn( feeDAO.getCreatedOn() );

        return fee;
    }

    @Override
    public List<Fee> toFees(List<FeeDAO> feeDAOs) {
        if ( feeDAOs == null ) {
            return null;
        }

        List<Fee> list = new ArrayList<Fee>( feeDAOs.size() );
        for ( FeeDAO feeDAO : feeDAOs ) {
            list.add( toFee( feeDAO ) );
        }

        return list;
    }

    @Override
    public FeeDAO toFeeDAO(Fee fee) {
        if ( fee == null ) {
            return null;
        }

        FeeDAO feeDAO = new FeeDAO();

        feeDAO.setCreatedBy( fee.getUser() );
        if ( fee.getAmount() != null ) {
            feeDAO.setAmount( fee.getAmount() );
        }
        feeDAO.setVehicleType( fee.getVehicleType() );
        feeDAO.setKilometrage( fee.getKilometrage() );
        feeDAO.setPostalCode( fee.getPostalCode() );
        feeDAO.setCreatedOn( fee.getCreatedOn() );

        return feeDAO;
    }
}
