package com.sammal.plantation.users.service;

import com.sammal.plantation.users.domain.Address;
import com.sammal.plantation.users.dto.AddressResponse;
import com.sammal.plantation.users.dto.AddressesResponse;
import com.sammal.plantation.users.repository.AddressRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    @DisplayName("주소를 넣은 후 검색한다.")
    void insertAndFindAddressTest() throws UserPrincipalNotFoundException {
        //given
        Address address = Address.builder()
                .userCode(1L)
                .addressResponse(AddressResponse.builder()
                        .addressName("우리집")
                        .name("김완수")
                        .phone("01051792628")
                        .addressDetail("둥지길 6-3")
                        .build())
                .build();

        //when
        addressRepository.save(address);
        AddressesResponse addressesResponse = addressService.selectAddresses(1L);

        //then
        Assertions.assertEquals(1, addressesResponse.getAddressList().size());
        Assertions.assertEquals("우리집", addressesResponse.getAddressList().get(0).getAddressName());
        Assertions.assertEquals("둥지길 6-3", addressesResponse.getAddressList().get(0).getAddressDetail());
    }
}
