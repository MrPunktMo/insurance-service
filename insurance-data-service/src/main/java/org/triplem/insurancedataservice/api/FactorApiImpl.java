package org.triplem.insurancedataservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.triplem.insurancedataservice.data.factor.service.FactorKilometrageService;
import org.triplem.insurancedataservice.data.factor.service.FactorRegionService;
import org.triplem.insurancedataservice.data.factor.service.FactorVehicleTypeService;
import org.triplem.insurancedataservice.models.FactorKilometrage;
import org.triplem.insurancedataservice.models.FactorRegion;
import org.triplem.insurancedataservice.models.FactorVehicleType;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FactorApiImpl implements FactorApi {

    private final FactorRegionService regionService;
    private final FactorKilometrageService kilometrageService;
    private final FactorVehicleTypeService vehicleTypeService;

    @Override
    public ResponseEntity<List<FactorKilometrage>> getFactorKilometrages() {
        return ResponseEntity.ok(kilometrageService.getKilometrages());
    }

    @Override
    public ResponseEntity<List<FactorRegion>> getFactorRegions() {
        return ResponseEntity.ok(regionService.getFactorRegions());
    }

    @Override
    public ResponseEntity<List<FactorVehicleType>> getFactorVehicleType() {
        return ResponseEntity.ok(vehicleTypeService.getFactorVehicleTypes());
    }
}
