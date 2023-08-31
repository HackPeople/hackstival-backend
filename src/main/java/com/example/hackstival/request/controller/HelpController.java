package com.example.hackstival.request.controller;


import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.request.service.HelpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "help", description = "도움 요청과 관련된 API")
@RequiredArgsConstructor
public class HelpController {

    private final HelpService helpService;

    @GetMapping("/help/all")
    @Operation(summary = "도움 전체 정보 조회")
    public List<HelpDTO> retriveAllHelpRequestList() {
        return helpService.retriveAllHelpRequestList();
    }

    @PostMapping("/help")
    @Operation(summary = "도움 정보 생성")
    public Long createHelpRequest(@RequestBody HelpDTO helpDTO)  {
        return helpService.createHelpRequest(helpDTO);
    }


}
