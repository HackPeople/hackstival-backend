package com.example.hackstival.user.controller;


import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.dto.SearchCondition;
import com.example.hackstival.user.dto.StatisticsInfo;
import com.example.hackstival.user.dto.UserDTO;
import com.example.hackstival.user.service.HelperUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequiredArgsConstructor
@Tag(name = "helper", description = "헬퍼 화면에서 사용하는 API")
public class HelperUserController {
    private final HelperUserService helperUserService;

    @GetMapping("/helper/requests")
    @Operation(summary = "요청된 도움 정보 동적 조회")
    public List<HelpDTO> retrieveHelpRequestToHelper(SearchCondition searchCondition) {
        return helperUserService.retrieveHelpRequestToHelper(searchCondition);
    }

    @GetMapping("/helper/accpeteds")
    @Operation(summary = "헬퍼가 수락한 정보 조회")
    public List<HelpDTO> retrieveHelpRequestToHelper(@RequestParam Long helperId) {
        return helperUserService.retrieveAccpetedHelps(helperId);
    }

    @PostMapping("/helper")
    public Long createOldUser(@RequestBody UserDTO userDTO) {
        return helperUserService.createHelperUser(userDTO);
    }

    @GetMapping("/helper/statistics")
    @Operation(summary = "헬퍼 통계정보조회")
    public StatisticsInfo retrieveStatisticAboutHelps(@RequestParam Long helperId) {
        return helperUserService.retrieveStatisticAboutHelps(helperId);
    }
}
