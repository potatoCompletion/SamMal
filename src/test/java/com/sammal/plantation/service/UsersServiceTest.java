package com.sammal.plantation.service;

import com.sammal.plantation.users.domain.Users;
import com.sammal.plantation.users.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsersServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원가입 테스트")
    void insertTest() {
        //given
        Users users = Users.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .phone("01051792628")
                .address("강원도 삼척시")
                .email("kws9623@naver.com")
                .build();

        //when
        userRepository.save(users);

        //then
        Assertions.assertEquals(1, userRepository.findAll().size());
        Assertions.assertEquals("kws2628", userRepository.findById(1L).get().getUserId());
    }
}
