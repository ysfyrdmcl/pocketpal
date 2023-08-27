package com.demo.pocketpal.dto.response;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IrregularFlowResponseDto {
    private Long id;
    private String name;

    private Double amount;

    private LocalDate date;
}
