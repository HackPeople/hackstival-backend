package com.example.hackstival.user.service;

import com.example.hackstival.user.domain.BaseUser;
import com.example.hackstival.user.domain.HelperUserRepository;
import com.example.hackstival.user.domain.OldUserRepository;
import com.example.hackstival.user.domain.UserRepository;
import com.example.hackstival.user.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDTO retrieveUserInfo(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(IllegalAccessError::new)
                .toDTO();
    }


}
