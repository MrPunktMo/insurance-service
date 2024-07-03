package org.triplem.insurancedataservice.data.faktor.mapper;

import com.tsystems.spots.models.FeeRequest;
import com.tsystems.spots.models.FeeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.faktor.model.FeeDAO;

import java.util.List;

@Mapper
public interface FeeMapper {

    FeeMapper MAPPER = Mappers.getMapper(FeeMapper.class);

    FeeResponse toFeeResponse(FeeDAO feeDAO);

    List<FeeResponse> toFeeResponses(List<FeeDAO> feeDAOs);

    @Mapping(target = "feeId", ignore = true)
    @Mapping(target = "region", source = "region")
    @Mapping(target = "createdBy", source = "feeRequest.userName")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "createdOn", ignore = true)
    FeeDAO toFeeDAO (FeeRequest feeRequest, String region, Float amount);

}
