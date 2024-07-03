package org.triplem.insurancedataservice.api;

import com.tsystems.spots.api.FeeApi;
import com.tsystems.spots.models.FeeRequest;
import com.tsystems.spots.models.FeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.triplem.insurancedataservice.data.faktor.service.FeeService;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class FeeApiImpl implements FeeApi {

    private final FeeService feeService;

    @Override
    public ResponseEntity<List<FeeResponse>> getAllFees() {
        return ResponseEntity.ok(feeService.getAllFees());
    }

    @Override
    public ResponseEntity<FeeResponse> postRequestFee(FeeRequest feeRequest) {

        if(Objects.isNull(feeRequest))
            return ResponseEntity.badRequest().build();
        else if (Objects.isNull(feeRequest.getKilometrage()) || Objects.isNull(feeRequest.getPostalCode()) || Objects.isNull(feeRequest.getVehicleType()))
            return ResponseEntity.badRequest().build();

        return FeeApi.super.postRequestFee(feeRequest);
    }
}
