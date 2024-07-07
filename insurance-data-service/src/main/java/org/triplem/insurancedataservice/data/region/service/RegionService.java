package org.triplem.insurancedataservice.data.region.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.mapper.RegionMapper;
import org.triplem.insurancedataservice.data.region.repository.RegionRepository;
import org.triplem.insurancedataservice.models.Region;
import org.triplem.insurancedataservice.util.exception.RegionNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public List<Region> getRegions() {
        return RegionMapper.MAPPER.toRegions(regionRepository.findAll());
    }

}
