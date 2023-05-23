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
@Slf4j
@Validated
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public void join(@RequestBody @Valid JoinParam request) {

        userService.insertUser(request);
    }

    @GetMapping("/user/{userCode}")
    public ResponseEntity<UserResponse> selectUserInfo(@PathVariable Long userCode) throws UserPrincipalNotFoundException {

        UserResponse response = userService.selectUser(userCode);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user/{userCode}")
    public void updateUserInfo(@PathVariable Long userCode,
                               @RequestBody @Valid UpdateUserParam request) throws UserPrincipalNotFoundException {

        userService.updateUser(userCode, request);
    }
}
