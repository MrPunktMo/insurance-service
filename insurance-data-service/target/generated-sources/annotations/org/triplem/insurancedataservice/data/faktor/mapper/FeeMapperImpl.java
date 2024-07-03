package org.triplem.insurancedataservice.data.faktor.mapper;

import com.tsystems.spots.models.FeeRequest;
import com.tsystems.spots.models.FeeResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.triplem.insurancedataservice.data.faktor.model.FeeDAO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-02T18:10:54+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.11 (Azul Systems, Inc.)"
)
public class FeeMapperImpl implements FeeMapper {

    @Override
    public FeeResponse toFeeResponse(FeeDAO feeDAO) {
        if ( feeDAO == null ) {
            return null;
        }

        FeeResponse feeResponse = new FeeResponse();

        feeResponse.setAmount( feeDAO.getAmount() );
        feeResponse.setKilometrage( feeDAO.getKilometrage() );
        feeResponse.setRegion( feeDAO.getRegion() );
        feeResponse.setVehicleType( feeDAO.getVehicleType() );
        feeResponse.setCreatedOn( feeDAO.getCreatedOn() );

        return feeResponse;
    }

    @Override
    public List<FeeResponse> toFeeResponses(List<FeeDAO> feeDAOs) {
        if ( feeDAOs == null ) {
            return null;
        }

        List<FeeResponse> list = new ArrayList<FeeResponse>( feeDAOs.size() );
        for ( FeeDAO feeDAO : feeDAOs ) {
            list.add( toFeeResponse( feeDAO ) );
        }

        return list;
    }

    @Override
    public FeeDAO toFeeDAO(FeeRequest feeRequest, String region, Float amount) {
        if ( feeRequest == null && region == null && amount == null ) {
            return null;
        }

        FeeDAO feeDAO = new FeeDAO();

        if ( feeRequest != null ) {
            feeDAO.setCreatedBy( feeRequest.getUserName() );
            feeDAO.setVehicleType( feeRequest.getVehicleType() );
            feeDAO.setKilometrage( feeRequest.getKilometrage() );
        }
        feeDAO.setRegion( region );
        if ( amount != null ) {
            feeDAO.setAmount( amount );
        }

        return feeDAO;
    }
}
