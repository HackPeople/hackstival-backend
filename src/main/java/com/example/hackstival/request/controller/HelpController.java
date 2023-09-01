package com.example.hackstival.request.controller;


import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.request.service.HelpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")

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
    public Long createHelpRequest(@RequestBody HelpDTO helpDTO) {
        return helpService.createHelpRequest(helpDTO);
    }

    @PutMapping("/help/accept")
    @Operation(summary = "도움 수락")
    public void accpetHelp(@RequestParam Long helpId, @RequestParam Long helperId) {
        helpService.accpetHelp(helpId, helperId);
    }

    @PutMapping("/help/confirm")
    @Operation(summary = "도움 확정")
    public void confirmHelp(@RequestParam Long helpId) {
        helpService.confirmHelp(helpId);
    }

    @PutMapping("/help/cancle")
    @Operation(summary = "도움 취소")
    public void cancleHelp(@RequestParam Long helpId) {
        helpService.cancleHelp(helpId);
    }

    @PutMapping("/help/done")
    @Operation(summary = "도움 완료")
    public void doneHelp(@RequestParam Long helpId, int stars) {
        helpService.doneHelp(helpId, stars);
    }
}
