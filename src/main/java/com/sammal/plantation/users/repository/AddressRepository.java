package com.sammal.plantation.users.repository;

import com.sammal.plantation.users.domain.Address;
import com.sammal.plantation.users.domain.AddressId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, AddressId> {

    List<Address> findByUserCode(Long userCode);
}
