package com.example.hackstival.user.domain;

import com.example.hackstival.common.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
    // persnal info
    private String userId;
    private String userPw;
    private String userPhoneNum;

    // social info
    private String nickName;
}