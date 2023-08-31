package com.example.hackstival.request.domain;

import com.example.hackstival.common.domain.Address;
import com.example.hackstival.common.domain.BaseEntity;
import com.example.hackstival.request.dto.HelpDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Help extends BaseEntity {

    private String content;
    private RequestType requestType;

    @Embedded
    private MoveInfo moveInfo;

    private Long money;

    private String oldUserId;
    private String helperUserId;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private RequestStatus requestStatus;

    public static Help registerHelp(HelpDTO helpDTO) {
        return Help.builder()
                .content(helpDTO.getContent())
                .requestType(helpDTO.getRequestType())
                .moveInfo(new MoveInfo(helpDTO.getStartAddress(), helpDTO.getDestinationAddress(), helpDTO.getMoveType()))
                .money(helpDTO.getMoney())
                .oldUserId(helpDTO.getOldUserId())
                .helperUserId(helpDTO.getHelperUserId())
                .startTime(helpDTO.getStartTime())
                .endTime(helpDTO.getEndTime())
                .requestStatus(helpDTO.getRequestStatus())
                .build();
    }

    private void expireUser() {
        if(requestStatus.isDecided()) return;
        if(startTime.isAfter(LocalDateTime.now())) requestStatus = RequestStatus.EXPIRE;
    }

    public HelpDTO toDTO() {
        return HelpDTO.builder()
                .id(getId())
                .content(content)
                .requestType(requestType)
                .moveType(moveInfo.getMoveType())
                .startAddress(moveInfo.getStartAddress())
                .destinationAddress(moveInfo.getDestinationAddress())
                .money(money)
                .oldUserId(oldUserId)
                .helperUserId(helperUserId)
                .startTime(startTime)
                .endTime(endTime)
                .requestStatus(requestStatus)
                .build();
    }

}
