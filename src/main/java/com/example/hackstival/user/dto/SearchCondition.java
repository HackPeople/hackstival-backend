package com.example.hackstival.user.dto;

import com.example.hackstival.request.domain.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "조회 조건 DTO")
public class SearchCondition {
    @Schema(description = "시작 시간", defaultValue = "2023/08/31 08:00")
    private String startTime;
    @Schema(description = "종료 시간", defaultValue = "2023/09/30 09:00")
    private String endTime;
    @Schema(description = "요청 유형 리스트")
    private List<RequestType> requestTypes;
    @Schema(description = "헬퍼 출발지 (동 기준 조회)")
    private String dongName;
    private SortType sortType;
}
