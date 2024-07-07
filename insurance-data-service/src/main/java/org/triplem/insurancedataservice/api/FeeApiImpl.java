package org.triplem.insurancedataservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.triplem.insurancedataservice.data.factor.service.FeeService;
import org.triplem.insurancedataservice.models.Fee;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class FeeApiImpl implements FeeApi {

    private final FeeService feeService;

    @Override
    public ResponseEntity<List<Fee>> getAllFees() {
        return ResponseEntity.ok(feeService.getAllFees());
    }

    @Override
    public ResponseEntity<Fee> saveFee(Fee fee) {

        if(Objects.isNull(fee))
            return ResponseEntity.badRequest().build();

        Fee savedFee = feeService.saveFee(fee);

        if(Objects.isNull(savedFee))
            return ResponseEntity.internalServerError().build();
        else
            return ResponseEntity.ok(fee);

    }



}
