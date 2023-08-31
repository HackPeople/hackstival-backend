package com.example.hackstival.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatisticsInfo {
    private int totalHelpCount;
    private int monthHelpCount;
    private int totalMoney;
    private int everageStar;
}
