package com.sammal.plantation.users.service;

import com.sammal.plantation.users.domain.Users;
import com.sammal.plantation.users.dto.JoinForm;
import com.sammal.plantation.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void insertUser(JoinForm joinForm) {

        Users users = Users.builder()
                .userId(joinForm.getUserId())
                .password(joinForm.getPassword())
                .phone(joinForm.getPhone())
                .address(joinForm.getAddress())
                .email(joinForm.getEmail())
                .build();

        userRepository.save(users);
    }
}
