package com.example.hackstival.user.domain;

import com.example.hackstival.request.domain.RequestType;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HelperUser extends BaseUser {
    private String pocketMoney; // 총 용돈 금액
    private RequestType interestedRequestType;
}
