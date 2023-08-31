package com.example.hackstival.user.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "user", description = "유저 공통 컨트롤러")
@RequiredArgsConstructor
public class UserController {
}
