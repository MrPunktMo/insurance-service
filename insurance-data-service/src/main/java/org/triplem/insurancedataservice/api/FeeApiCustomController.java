package org.triplem.insurancedataservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.triplem.insurancedataservice.data.factor.service.FeeService;
import org.triplem.insurancedataservice.models.Fee;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class FeeApiCustomController {

    private final FeeService feeService;

    @GetMapping("/user/fee")
    public ResponseEntity<List<Fee>> getAllFeesOfUser(Authentication authentication) {

        if(Objects.isNull(authentication) || Objects.isNull(authentication.getName()))
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(feeService.getFeesOfUser(authentication.getName()));

    }

}
