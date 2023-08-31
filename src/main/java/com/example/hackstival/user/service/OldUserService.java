package com.example.hackstival.user.service;

import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.domain.HelpRepository;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.domain.OldUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OldUserService {

    public final OldUserRepository oldUserRepository;

    public final HelpRepository helpRepository;

    // 자신의 요청사항 조회
    public List<HelpDTO> retriveAllHelpRequestList() {
        List<Help> helps = helpRepository.findAll();
        return helps.stream().map(o -> o.toDTO()).toList();
    }

    // 도움 요청
     public Long createHelpRequest(HelpDTO helpDTO) {
        return helpRepository.save(Help.registerHelp(helpDTO)).getId();
    }
}
