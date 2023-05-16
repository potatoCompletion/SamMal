package com.sammal.plantation.users.dto;

import com.sammal.plantation.users.domain.Address;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddressResponse {

    List<AddressInfo> addressList;

    public AddressResponse(List<AddressInfo> addressList) {

        this.addressList = addressList;
    }
}
