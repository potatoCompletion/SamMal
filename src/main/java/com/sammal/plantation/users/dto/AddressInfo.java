package com.sammal.plantation.users.dto;

import com.sammal.plantation.users.domain.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressInfo {
    private String addressName;
    private String addressDetail;

    @Builder
    public AddressInfo(String addressName, String addressDetail) {

        this.addressName = addressName;
        this.addressDetail = addressDetail;
    }

    public AddressInfo(Address address) {
        this.addressName = address.getAddressName();
        this.addressDetail = address.getAddressDetail();
    }
}
