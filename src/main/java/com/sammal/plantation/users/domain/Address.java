package com.sammal.plantation.users.domain;

import com.sammal.plantation.users.dto.AddressInfo;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@IdClass(AddressId.class)
public class Address implements Serializable {

    @Id
    private Long userCode;
    @Id
    @NotBlank(message = "주소명은 필수 값입니다.")
    private String addressName;
    @NotBlank(message = "주소는 필수 값입니다.")
    private String addressDetail;

    @Builder
    public Address(Long userCode, AddressInfo addressInfo) {

        this.userCode = userCode;
        this.addressName = addressInfo.getAddressName();
        this.addressDetail = addressInfo.getAddressDetail();
    }
}
