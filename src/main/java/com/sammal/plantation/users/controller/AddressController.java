package com.sammal.plantation.users.controller;

import com.sammal.plantation.users.dto.AddressResponse;
import com.sammal.plantation.users.dto.AddressesResponse;
import com.sammal.plantation.users.service.AddressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
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

    /**
     * 해당 유저의 배송지 목록조회
     * @param userCode
     * @return
     * @throws UserPrincipalNotFoundException
     */
    @GetMapping("/addresses/{userCode}")
    public ResponseEntity<AddressesResponse> getAddresses(@PathVariable Long userCode) throws UserPrincipalNotFoundException {

        AddressesResponse response = addressService.selectAddresses(userCode);

        return ResponseEntity.ok(response);
    }

    /**
     * 해당 유저의 특정 배송지 검색
     * @param userCode
     * @param addressName
     * @return
     * @throws UserPrincipalNotFoundException
     */
    @GetMapping("/address/{userCode}/{addressName}")
    public ResponseEntity<AddressResponse> getAddress(@PathVariable Long userCode, @PathVariable String addressName) throws UserPrincipalNotFoundException {

        AddressResponse response = addressService.selectAddress(userCode, addressName);

        return ResponseEntity.ok(response);
    }

    /**
     * 해당 유저의 특정 배송지 삭제
     * @param userCode
     * @param addressName
     * @throws UserPrincipalNotFoundException
     */
    @DeleteMapping("/address/{userCode}/{addressName}")
    public void deleteAddress(@PathVariable Long userCode, @PathVariable String addressName) throws UserPrincipalNotFoundException {

        addressService.deleteAddress(userCode, addressName);
    }
}
