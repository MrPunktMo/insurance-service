package org.triplem.insurancedataservice.data.factor.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.triplem.insurancedataservice.data.factor.model.FeeDAO;
import org.triplem.insurancedataservice.models.Fee;

import java.util.List;

@Mapper
public interface FeeMapper {

    FeeMapper MAPPER = Mappers.getMapper(FeeMapper.class);

    @Mapping(target = "user", source = "createdBy")
    Fee toFee(FeeDAO feeDAO);

    List<Fee> toFees(List<FeeDAO> feeDAOs);

    @Mapping(target = "feeId", ignore = true)
    @Mapping(target = "createdBy", source = "user")
    FeeDAO toFeeDAO (Fee fee);

}
