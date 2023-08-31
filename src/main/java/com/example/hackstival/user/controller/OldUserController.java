package com.example.hackstival.user.controller;

import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.dto.SearchCondition;
import com.example.hackstival.user.dto.UserDTO;
import com.example.hackstival.user.service.HelperUserService;
import com.example.hackstival.user.service.OldUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "oldUser", description = "노인과 관련된 컨트롤러")
@RequiredArgsConstructor
public class OldUserController {

    private final OldUserService oldUserService;

    @GetMapping("/olduser/helps")
    @Operation(summary = "노인이 자신이 요청한 도움 목록 조회")
    public List<HelpDTO> retriveHelpsByUser(@RequestParam Long oldUserId) {
        return oldUserService.retriveHelpsByUser(oldUserId);
    }

    @PostMapping("/olduser")
    public Long createOldUser(@RequestBody UserDTO userDTO) {
        return oldUserService.createOldUser(userDTO);
    }

}
