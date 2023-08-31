package com.example.hackstival.request.service;


import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.domain.HelpRepository;
import com.example.hackstival.request.domain.RequestStatus;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.domain.HelperUser;
import com.example.hackstival.user.domain.HelperUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HelpService {

    private final HelperUserRepository helperUserRepository;
    private final HelpRepository helpRepository;

    public List<HelpDTO> retriveAllHelpRequestList() {
        List<Help> helps = helpRepository.findAll();
        return helps.stream().map(o -> o.toDTO()).collect(Collectors.toList());
    }

    public Long createHelpRequest(HelpDTO helpDTO) {
        return helpRepository.save(Help.registerHelp(helpDTO)).getId();
    }

    public void accpetHelp(Long helpId, Long helperId) {
        Help help = helpRepository.findById(helpId).orElseThrow(IllegalAccessError::new);
        help.acceptHelp(helperId);
    }

    public void confirmHelp(Long helpId) {
        Help help = helpRepository.findById(helpId).orElseThrow(IllegalAccessError::new);
        help.confirmHelp();
    }

    public void cancleHelp(Long helpId) {
        Help help = helpRepository.findById(helpId).orElseThrow(IllegalAccessError::new);
        help.cancleHelp();
    }

    public void doneHelp(Long helpId) {
        Help help = helpRepository.findById(helpId).orElseThrow(IllegalAccessError::new);
        help.doneHelp();
        HelperUser helperUser = helperUserRepository.findById(help.getHelperUserId()).orElseThrow(IllegalAccessError::new);
        helperUser.addMoney(help.getMoney());
    }
}
