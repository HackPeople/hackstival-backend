package com.example.hackstival.user.domain;

import com.example.hackstival.common.domain.Address;
import com.example.hackstival.common.domain.BaseEntity;
import com.example.hackstival.user.dto.UserDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class BaseUser extends BaseEntity {
    // persnal info
    private String userId;
    private String userPw;
    private String userName;
    private String userPhoneNumber;

    // social info
    private String profileImage;

    // 주소
    @Embedded
    private Address address;

    // 성별
    private SexType sexType;


    public UserDTO toDTO() {
        return UserDTO.builder()
                .id(getId())
                .userId(userId)
                .userPw(userPw)
                .address(address)
                .profileImage(profileImage)
                .userName(userName)
                .userPhoneNumber(userPhoneNumber)
                .sexType(sexType)
                .build();
    }

}