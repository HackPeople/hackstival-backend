package com.example.hackstival.user.domain;

import com.example.hackstival.user.dto.UserDTO;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class OldUser extends BaseUser {
    private Long guardianId;

    public static OldUser createOldUser(UserDTO userDTO) {
        return OldUser.builder()
                .userId(userDTO.getUserId())
                .userPw(userDTO.getUserPw())
                .userName(userDTO.getUserName())
                .userPhoneNumber(userDTO.getUserPhoneNumber())
                .profileImage(userDTO.getProfileImage())
                .address(userDTO.getAddress())
                .sexType(userDTO.getSexType())
                .build();
    }
}
