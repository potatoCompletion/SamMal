package com.sammal.plantation.users.service;

import com.sammal.plantation.users.domain.Address;
import com.sammal.plantation.users.dto.AddressResponse;
import com.sammal.plantation.users.dto.AddressesResponse;
import com.sammal.plantation.users.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressesResponse selectAddresses(Long userCode) throws UserPrincipalNotFoundException {

        List<AddressResponse> addressList = addressRepository.findByUserCode(userCode)
                .stream()
                .map(AddressResponse::new)
                .toList();

        if (addressList.isEmpty()) {
            throw new UserPrincipalNotFoundException("검색되는 주소가 없습니다.");
        }

        return new AddressesResponse(addressList);
    }

    public AddressResponse selectAddress(Long userCode, String addressName) throws UserPrincipalNotFoundException {

        return new AddressResponse(
                addressRepository.findByUserCodeAndAddressName(userCode, addressName).orElseThrow(() ->
                        new UserPrincipalNotFoundException("찾고자 하는 주소가 없습니다."))
        );
    }

    public void insertAddress(Long userCode, AddressResponse addressResponse) {

        Address address = Address.builder()
                .userCode(userCode)
                .addressResponse(addressResponse)
                .build();

        addressRepository.save(address);
    }

//    public void deleteAddress()
}
