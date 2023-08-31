package com.example.hackstival.user.domain;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class OldUser extends BaseUser {
    private String guardianId;
}
