package com.sammal.plantation.users.controller;

import com.sammal.plantation.users.dto.AddressResponse;
import com.sammal.plantation.users.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RequiredArgsConstructor
@RestController
@Slf4j
@Validated
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address/{userCode}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable Long userCode) throws UserPrincipalNotFoundException {

        AddressResponse response = addressService.selectAddress(userCode);

        return ResponseEntity.ok(response);
    }
}
