package com.sammal.plantation.users.controller;

import com.sammal.plantation.users.dto.JoinParam;
import com.sammal.plantation.users.dto.UpdateUserParam;
import com.sammal.plantation.users.dto.UserResponse;
import com.sammal.plantation.users.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
@Slf4j
@Validated
public class UserController {

    private final UserService userService;

    /**
     * 유저 등록
     * @param request
     */
    @PostMapping("")
    public void join(@RequestBody @Valid JoinParam request) {

        userService.insertUser(request);
    }

    /**
     * 유저 선택
     * @param userCode
     * @return
     * @throws UserPrincipalNotFoundException
     */
    @GetMapping("/{userCode}")
    public ResponseEntity<UserResponse> selectUserInfo(@PathVariable Long userCode) throws UserPrincipalNotFoundException {

        UserResponse response = userService.selectUser(userCode);
        return ResponseEntity.ok(response);
    }

    /**
     * 유저 정보 업데이트
     * @param userCode
     * @param request
     * @throws UserPrincipalNotFoundException
     */
    @PostMapping("/{userCode}")
    public void updateUserInfo(@PathVariable Long userCode,
                               @RequestBody @Valid UpdateUserParam request) throws UserPrincipalNotFoundException {

        userService.updateUser(userCode, request);
    }
}
