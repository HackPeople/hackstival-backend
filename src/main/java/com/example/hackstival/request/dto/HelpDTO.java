package com.example.hackstival.request.dto;

import com.example.hackstival.common.domain.Address;
import com.example.hackstival.request.domain.MoveType;
import com.example.hackstival.request.domain.RequestStatus;
import com.example.hackstival.request.domain.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Schema(description = "도움 요청 기본 DTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HelpDTO {
    @Schema(description = "기본 아이디")
    private Long id;
    @Schema(description = "상세 정보")
    private String content;
    @Schema(description = "도움 시작 시간", defaultValue = "2023/08/31 08:56")
    private String startTime;
    @Schema(description = "도움 종료 시간", defaultValue = "2023/08/31 08:56")
    private String endTime;
    @Schema(description = "요청 유형")
    private RequestType requestType;
    @Schema(description = "출발지")
    private Address startAddress;
    @Schema(description = "도착지")
    private Address destinationAddress;
    @Schema(description = "편도 왕복 등 타입")
    private MoveType moveType;
    @Schema(description = "용돈")
    private Long money;
    @Schema(description = "노인 아이디")
    private String oldUserId;
    @Schema(description = "헬퍼 아이디")
    private String helperUserId;
    @Schema(description = "도움 요청의 현재 상태 (요청, 수락, 매칭, 수락이후 거절, 만료)")
    private RequestStatus requestStatus;
}
