package com.example.hackstival.request.domain;

import com.example.hackstival.common.domain.BaseEntity;
import com.example.hackstival.request.dto.HelpDTO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

import static com.example.hackstival.common.Constant.*;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
public class Help extends BaseEntity {

    private String content;
    private RequestType requestType;

    @Embedded
    private MoveInfo moveInfo;

    private Long money;

    private Long oldUserId;
    private Long helperUserId;

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
                .startTime(parseFullDateTime(helpDTO.getStartTime()))
                .endTime(parseFullDateTime(helpDTO.getEndTime()))
                .requestStatus(helpDTO.getRequestStatus())
                .build();
    }

    public void expireUser() {
        if (requestStatus.isDecided()) return;
        if (startTime.isAfter(LocalDateTime.now())) requestStatus = RequestStatus.EXPIRE;
    }

    public void acceptHelp(Long helperUserId) {
        if (requestStatus == RequestStatus.REQUEST) requestStatus = RequestStatus.ACCEPTED;
        this.helperUserId = helperUserId;
    }

    public void confirmHelp() {
        if (requestStatus == RequestStatus.ACCEPTED) requestStatus = RequestStatus.CONFIRMED;
    }

    public void cancleHelp() {
        requestStatus = RequestStatus.CANCLE;
    }

    public void doneHelp() {
        if (requestStatus == RequestStatus.CONFIRMED) requestStatus = RequestStatus.DONE;
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
                .startTime(startTime.format(SIMPLE_DATE_FORMATTER))
                .endTime(endTime.format(SIMPLE_DATE_FORMATTER))
                .requestStatus(requestStatus)
                .build();
    }
}
