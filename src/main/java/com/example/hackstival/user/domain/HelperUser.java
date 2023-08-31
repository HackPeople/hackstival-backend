package com.example.hackstival.user.domain;

import com.example.hackstival.request.domain.RequestType;
import com.example.hackstival.user.dto.UserDTO;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class HelperUser extends BaseUser {
    private Long totalMoney; // 총 용돈 금액
    private RequestType interestedRequestType;

    public static HelperUser createHelperUser(UserDTO userDTO) {
        return HelperUser.builder()
                .userId(userDTO.getUserId())
                .userPw(userDTO.getUserPw())
                .userName(userDTO.getUserName())
                .userPhoneNumber(userDTO.getUserPhoneNumber())
                .profileImage(userDTO.getProfileImage())
                .address(userDTO.getAddress())
                .sexType(userDTO.getSexType())
                .totalMoney(0l)
                .interestedRequestType(userDTO.getInterestedRequestType())
                .build();
    }
}
