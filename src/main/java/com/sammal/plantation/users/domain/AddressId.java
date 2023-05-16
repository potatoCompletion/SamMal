package com.sammal.plantation.users.domain;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressId implements Serializable {

    private Long userCode;
    private String addressName;
}
