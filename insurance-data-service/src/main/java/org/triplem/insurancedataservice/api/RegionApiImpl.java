package org.triplem.insurancedataservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.triplem.insurancedataservice.data.region.service.RegionService;
import org.triplem.insurancedataservice.models.Region;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RegionApiImpl implements RegionApi {

    private final RegionService regionService;

    @Override
    public ResponseEntity<List<Region>> getRegions() {
        return ResponseEntity.ok(regionService.getRegions());
    }

}
