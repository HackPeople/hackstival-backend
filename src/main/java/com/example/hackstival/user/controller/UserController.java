package com.example.hackstival.user.controller;


import com.example.hackstival.user.dto.UserDTO;
import com.example.hackstival.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@Tag(name = "user", description = "유저 공통 컨트롤러")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/user")
    @Operation(summary = "유저 프로필 조회")
    public UserDTO retrieveUserInfo(@RequestParam Long userId) {
        return userService.retrieveUserInfo(userId);
    }
}
