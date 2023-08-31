package com.example.hackstival.request.service;


import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.domain.HelpRepository;
import com.example.hackstival.request.dto.HelpDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HelpService {
    private final HelpRepository helpRepository;

    public List<HelpDTO> retriveAllHelpRequestList() {
        List<Help> helps = helpRepository.findAll();
        return helps.stream().map(o -> o.toDTO()).collect(Collectors.toList());
    }

    public Long createHelpRequest(HelpDTO helpDTO) {
        return helpRepository.save(Help.registerHelp(helpDTO)).getId();
    }
}
