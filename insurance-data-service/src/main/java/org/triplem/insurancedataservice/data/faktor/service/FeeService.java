package org.triplem.insurancedataservice.data.faktor.service;

import com.tsystems.spots.models.FeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.faktor.mapper.FeeMapper;
import org.triplem.insurancedataservice.data.faktor.repository.FeeRepository;
import org.triplem.insurancedataservice.data.faktor.repository.FactorVehicleTypeRepository;
import org.triplem.insurancedataservice.data.faktor.repository.FactorKilometrageRepository;
import org.triplem.insurancedataservice.data.faktor.repository.FactorRegionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeeService {

    private final FactorVehicleTypeRepository factorVehicleTypeRepository;
    private final FactorKilometrageRepository factorKilometrageRepository;
    private final FactorRegionRepository factorRegionRepository;
    private final FeeRepository feeRepository;

    public final List<FeeResponse> getAllFees() {
        return FeeMapper.MAPPER.toFeeResponses(feeRepository.findAll());
    }

    public final List<FeeResponse> getFeesOfUser(String userName) {
        return FeeMapper.MAPPER.toFeeResponses(feeRepository.findAllByCreatedBy(userName));
    }

}
