package com.example.hackstival.request.domain;

import com.example.hackstival.common.domain.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class MoveInfo {
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "doName", column = @Column(name = "start_do_name")),
        @AttributeOverride(name = "siName", column = @Column(name = "start_si_name")),
    @AttributeOverride(name = "dongName", column = @Column(name = "start_dong_name"))
    })
    private Address startAddress;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "doName", column = @Column(name = "destination_do_name")),
        @AttributeOverride(name = "siName", column = @Column(name = "destination_si_name")),
    @AttributeOverride(name = "dongName", column = @Column(name = "destination_dong_name"))
    })
    private Address destinationAddress;

    private MoveType moveType; // 왕복 편도
}
