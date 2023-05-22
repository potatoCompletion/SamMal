package com.sammal.plantation.users.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddressesResponse {

    List<AddressResponse> addressList;

    public AddressesResponse(List<AddressResponse> addressList) {

        this.addressList = addressList;
    }
}
