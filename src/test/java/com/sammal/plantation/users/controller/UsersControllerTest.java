package com.sammal.plantation.users.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sammal.plantation.users.dto.JoinParam;
import com.sammal.plantation.users.dto.UpdateUserParam;
import com.sammal.plantation.users.dto.UserResponse;
import com.sammal.plantation.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(new CharacterEncodingFilter("UTF-8", true))  // 필터 추가
                .alwaysDo(print())
                .build();
    }

    @Test
    @DisplayName("/user시 정상적으로 유저정보를 저장한다")
    void joinTest() throws Exception {
        //given
        JoinParam joinParam = JoinParam.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .phone("01051792628")
                .address("삼척시")
                .email("kws9623@naver.com")
                .build();

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinParam);

        //expected
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/user 이메일 형식을 검사한다")
    void invalidJoinEmailTest() throws Exception {
        //given
        JoinParam joinParam = JoinParam.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .name("김완수")
                .phone("01051792628")
                .address("삼척시")
                .email("kws9623")
                .build();

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinParam);

        //expected
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("올바른 이메일 형식이 아닙니다."));
    }

    @Test
    @DisplayName("/user 필수 값을 검증한다")
    void invalidJoinAddressTest() throws Exception {
        //given
        JoinParam joinParam = JoinParam.builder()   // 주소값 없는 parameter
                .userId("kws2628")
                .password("qweqweqwe")
                .name("김완수")
                .phone("01051792628")
                .email("kws9623")
                .build();

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinParam);

        //expected
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("주소는 필수 값입니다."));
    }

    @Test
    @DisplayName("없는 유저코드를 요청하면 에러메시지를 응답한다.")
    void invalidUserCode() throws Exception {
        //given
        Long userCode = 100L;   // 존재하지 않는 유저코드

        //expected
        mockMvc.perform(get("/user/" + userCode)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("해당하는 유저가 없습니다."));
    }

    @Test
    @DisplayName("유저 정보를 업데이트 한 후 조회하면 업데이트 된 정보를 응답한다.")
    void updateUserTest() throws Exception {
        //given
        JoinParam joinParam = JoinParam.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .name("김완수")
                .phone("01051792628")
                .address("강원도 삼척시")
                .email("kws9623@naver.com")
                .build();

        String joinJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinParam);

        UpdateUserParam updateUserParam = UpdateUserParam.builder()
                .phone("01012345678")
                .email("kimwansu@gmail.com")
                .build();

        String updateJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(updateUserParam);

        //expected
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(joinJson)
                )
                .andExpect(status().isOk());

        mockMvc.perform(post("/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson)
                )
                .andExpect(status().isOk());

        UserResponse userResponse = userService.selectUser(1L);
        String expectedResponse = mapper.writeValueAsString(userResponse);

        mockMvc.perform(get("/user/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateJson)
                )
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResponse));
    }
}
