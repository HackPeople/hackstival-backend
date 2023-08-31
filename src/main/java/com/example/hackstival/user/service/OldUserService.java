package com.example.hackstival.user.service;

import com.example.hackstival.request.domain.Help;
import com.example.hackstival.request.domain.HelpRepository;
import com.example.hackstival.request.domain.HelpRepositorySupport;
import com.example.hackstival.request.dto.HelpDTO;
import com.example.hackstival.user.domain.OldUser;
import com.example.hackstival.user.domain.OldUserRepository;
import com.example.hackstival.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OldUserService {

    public final OldUserRepository oldUserRepository;

    public final HelpRepositorySupport helpRepositorySupport;
    public final HelpRepository helpRepository;

    // 자신의 요청사항 조회
    public List<HelpDTO> retriveHelpsByUser(Long oldUserId) {
        List<Help> helps = helpRepository.findByOldUserIdOrderByCreatedDateDesc(oldUserId);
        return helps.stream().map(o -> o.toDTO()).toList();
    }

    public Long createOldUser(UserDTO userDTO) {
        return oldUserRepository.save(OldUser.createOldUser(userDTO)).getId();
    }
}
