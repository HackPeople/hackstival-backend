package com.example.hackstival.user.domain;

import com.example.hackstival.common.domain.Address;
import com.example.hackstival.common.domain.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class BaseUser extends BaseEntity {
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
}