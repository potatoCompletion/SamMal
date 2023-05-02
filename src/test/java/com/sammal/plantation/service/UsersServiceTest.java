package com.sammal.plantation.service;

import com.sammal.plantation.users.domain.Users;
import com.sammal.plantation.users.dto.JoinParam;
import com.sammal.plantation.users.dto.UserResponse;
import com.sammal.plantation.users.repository.UserRepository;
import com.sammal.plantation.users.service.UserService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@SpringBootTest
public class UsersServiceTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void clear() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("회원가입 테스트")
    void insertTest() {
        //given
        JoinParam joinParam = JoinParam.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .phone("01051792628")
                .address("강원도 삼척시")
                .email("kws9623@naver.com")
                .build();

        //when
        userService.insertUser(joinParam);

        //then
        Assertions.assertEquals(1, userRepository.findAll().size());
        Assertions.assertEquals("kws2628", userRepository.findById(1L).get().getUserId());
    }

    @Test
    @DisplayName("유저정보 조회 테스트")
    void selectTest() throws UserPrincipalNotFoundException {
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
        UserResponse userResponse = userService.selectUser(1L);

        //then
        Assertions.assertEquals("kws2628", userResponse.getUserId());
    }
}
