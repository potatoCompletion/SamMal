package com.sammal.plantation.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sammal.plantation.users.dto.JoinForm;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("/join시 정상적으로 유저정보를 저장한다")
    void joinTest() throws Exception {
        //given
        JoinForm joinForm = JoinForm.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .phone("01051792628")
                .address("삼척시")
                .email("kws9623@naver.com")
                .build();

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinForm);

        //expected
        mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/join시 이메일 형식을 검사한다")
    void invalidJoinEmailTest() throws Exception {
        //given
        JoinForm joinForm = JoinForm.builder()
                .userId("kws2628")
                .password("qweqweqwe")
                .phone("01051792628")
                .address("삼척시")
                .email("kws9623")
                .build();

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(joinForm);

        //expected
        mockMvc.perform(post("/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json)
                )
                .andExpect(status().isOk())
                .andExpect(content().string("올바른 이메일 형식이 아닙니다."));
    }
}
