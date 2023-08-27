package com.demo.pocketpal.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegularFlowResponseDto {
    private Long id;
    private String name;

    private Double amount;

    private int regularFlowDayOfEachMonth;
}
