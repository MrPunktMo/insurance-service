package org.triplem.insurancedataservice.data.factor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.factor.mapper.FeeMapper;
import org.triplem.insurancedataservice.data.factor.repository.FeeRepository;
import org.triplem.insurancedataservice.models.Fee;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeService {

    private final FeeRepository feeRepository;

    public final List<Fee> getAllFees() {
        return FeeMapper.MAPPER.toFees(feeRepository.findAll());
    }

    public final List<Fee> getFeesOfUser(String userName) {
        return FeeMapper.MAPPER.toFees(feeRepository.findAllByCreatedBy(userName));
    }

    public final Fee saveFee(Fee fee) {
        return FeeMapper.MAPPER.toFee(feeRepository.save(FeeMapper.MAPPER.toFeeDAO(fee)));
    }

}
