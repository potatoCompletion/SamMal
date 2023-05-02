package com.sammal.plantation.users.service;

import com.sammal.plantation.users.domain.Users;
import com.sammal.plantation.users.dto.JoinParam;
import com.sammal.plantation.users.dto.UserResponse;
import com.sammal.plantation.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void insertUser(JoinParam joinParam) {

        Users users = Users.builder()
                .userId(joinParam.getUserId())
                .password(joinParam.getPassword())
                .phone(joinParam.getPhone())
                .address(joinParam.getAddress())
                .email(joinParam.getEmail())
                .build();

        userRepository.save(users);
    }

    public UserResponse selectUser(Long id) throws UserPrincipalNotFoundException {

        Users users = userRepository.findById(id).orElseThrow(() -> new UserPrincipalNotFoundException("해당하는 유저가 없습니다."));

        return new UserResponse(users);
    }
}
