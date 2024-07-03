package org.triplem.insurancedataservice.data.region.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.triplem.insurancedataservice.data.region.repository.RegionRepository;
import org.triplem.insurancedataservice.util.exception.RegionNotFoundException;

@Service
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository regionRepository;

    public String getRegionFromPostcode(String postcode) {
        return regionRepository.findAll().stream()
                .filter(region -> region.getPostleitzahl().equals(postcode))
                .findFirst().orElseThrow(() -> new RegionNotFoundException("No region found with postcode: " + postcode))
                .getBundesLand();
    }

}
