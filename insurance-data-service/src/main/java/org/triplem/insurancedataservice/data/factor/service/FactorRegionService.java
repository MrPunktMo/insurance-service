package org.triplem.insurancedataservice.data.factor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.factor.mapper.FactorRegionMapper;
import org.triplem.insurancedataservice.data.factor.repository.FactorRegionRepository;
import org.triplem.insurancedataservice.models.FactorRegion;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactorRegionService {

    private final FactorRegionRepository factorRegionRepository;

    public List<FactorRegion> getFactorRegions() {
        return FactorRegionMapper.MAPPER.toFactorRegions(factorRegionRepository.getValidRegions());
    }

}
