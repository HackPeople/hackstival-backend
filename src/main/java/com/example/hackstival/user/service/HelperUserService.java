package com.example.hackstival.user.service;

import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.domain.HelpRepository;
import com.example.hackstival.request.domain.HelpRepositorySupport;
import com.example.hackstival.request.domain.RequestType;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.dto.SearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HelperUserService {
    public final HelpRepositorySupport helpRepositorySupport;

    // 자신의 통계 정보 조회

    // 필요한 도움 정보 조회
    public List<HelpDTO> retrieveHelpRequestToHelper(SearchCondition searchCondition) {
        return helpRepositorySupport.findHelpRequests(searchCondition)
                .stream().map(Help::toDTO)
                .toList();
    }
}
