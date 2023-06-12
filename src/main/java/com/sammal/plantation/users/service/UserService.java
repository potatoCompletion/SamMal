package com.sammal.plantation.users.service;

import com.sammal.plantation.users.domain.Users;
import com.sammal.plantation.users.dto.JoinParam;
import com.sammal.plantation.users.dto.UpdateUserParam;
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
                .name(joinParam.getName())
                .email(joinParam.getEmail())
                .build();

        userRepository.save(users);
    }

    public UserResponse selectUser(Long userCode) throws UserPrincipalNotFoundException {

        Users users = userRepository.findByUserCode(userCode).orElseThrow(() -> new UserPrincipalNotFoundException("해당하는 유저가 없습니다."));

        return new UserResponse(users);
    }

    public void updateUser(Long userCode, UpdateUserParam request) throws UserPrincipalNotFoundException {

        Users users = userRepository.findByUserCode(userCode).orElseThrow(() -> new UserPrincipalNotFoundException("해당하는 유저가 없습니다."));

        // 두번 업데이트 방지
        users.updatePhone(request.getPhone());
        users.updateEmail(request.getEmail());
    }
}
