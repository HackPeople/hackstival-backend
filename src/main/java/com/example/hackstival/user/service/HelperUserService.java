package com.example.hackstival.user.service;

import com.example.hackstival.request.domain.*;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.domain.HelperUser;
import com.example.hackstival.user.domain.HelperUserRepository;
import com.example.hackstival.user.domain.OldUser;
import com.example.hackstival.user.dto.SearchCondition;
import com.example.hackstival.user.dto.StatisticsInfo;
import com.example.hackstival.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HelperUserService {

    private final HelperUserRepository helperUserRepository;
    public final HelpRepositorySupport helpRepositorySupport;

    public final HelpRepository helpRepository;


    // 자신의 통계 정보 조회

    // 필요한 도움 정보 조회
    public List<HelpDTO> retrieveHelpRequestToHelper(SearchCondition searchCondition) {
        return helpRepositorySupport.findHelpRequests(searchCondition)
                .stream().map(Help::toDTO)
                .toList();
    }

    // 내가 수락한 정보 조회
    public List<HelpDTO> retrieveAccpetedHelps(Long helperId) {
        return helpRepository.findByHelperUserIdOrderByCreatedDateDesc(helperId)
                .stream().map(Help::toDTO)
                .toList();
    }

    public Long createHelperUser(UserDTO userDTO) {
        return helperUserRepository.save(HelperUser.createHelperUser(userDTO)).getId();
    }

    public StatisticsInfo retrieveStatisticAboutHelps(Long helperId) {
        List<Help> helps = helpRepository.findByHelperUserIdAndRequestStatus(helperId, RequestStatus.DONE);

        int monthHelpCount = Long.valueOf(helps.stream()
                .filter(o -> LocalDate.now().atStartOfDay().isBefore(o.getStartTime()))
                .count()).intValue();
        int totalStarCount = helps.stream()
                .mapToInt(o -> o.getStars())
                .sum();
        int totalMoney = Long.valueOf(helps.stream()
                .mapToLong(o -> o.getMoney())
                .sum()).intValue();

        return StatisticsInfo.builder()
                .totalHelpCount(helps.size())
                .monthHelpCount(monthHelpCount)
                .everageStar(helps.size() == 0 ? 0 : totalStarCount / helps.size())
                .totalMoney(totalMoney)
                .build();
    }

}
