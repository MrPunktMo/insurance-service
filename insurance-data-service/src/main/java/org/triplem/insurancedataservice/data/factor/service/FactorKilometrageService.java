package org.triplem.insurancedataservice.data.factor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.factor.mapper.FactorKilometrageMapper;
import org.triplem.insurancedataservice.data.factor.repository.FactorKilometrageRepository;
import org.triplem.insurancedataservice.models.FactorKilometrage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactorKilometrageService {

    private final FactorKilometrageRepository kilometrageRepository;

    public List<FactorKilometrage> getKilometrages() {
        return FactorKilometrageMapper.MAPPER.toFactorKilometrages(kilometrageRepository.getValidKilometrages());
    }

}
