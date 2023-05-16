package com.sammal.plantation.users.service;

import com.sammal.plantation.users.domain.Address;
import com.sammal.plantation.users.dto.AddressInfo;
import com.sammal.plantation.users.dto.AddressResponse;
import com.sammal.plantation.users.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressResponse selectAddress(Long userCode) throws UserPrincipalNotFoundException {

        List<AddressInfo> addressList = addressRepository.findByUserCode(userCode)
                .stream()
                .map(AddressInfo::new)
                .toList();

        if (addressList.isEmpty()) {
            throw new UserPrincipalNotFoundException("검색되는 주소가 없습니다.");
        }

        return new AddressResponse(addressList);
    }

    public void insertAddress(Long userCode, AddressInfo addressInfo) {

        Address address = Address.builder()
                .userCode(userCode)
                .addressInfo(addressInfo)
                .build();

        addressRepository.save(address);
    }
}
