package com.sammal.plantation.users.dto;

import com.sammal.plantation.users.domain.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private String addressName;
    private String name;
    private String phone;
    private String addressDetail;

    @Builder
    public AddressResponse(String addressName, String name, String phone, String addressDetail) {

        this.addressName = addressName;
        this.name = name;
        this.phone = phone;
        this.addressDetail = addressDetail;
    }

    public AddressResponse(Address address) {
        this.addressName = address.getAddressName();
        this.name = address.getName();
        this.phone = address.getPhone();
        this.addressDetail = address.getAddressDetail();
    }
}
