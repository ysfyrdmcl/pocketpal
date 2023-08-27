package com.demo.pocketpal.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegularFlowRequestDto {
    @Size(min = 3, message = "Name must be valid.")
    @NotNull(message = "Name must not be null.")
    @NotBlank(message = "Name must not be blank.")
    private String name;
    @Min(value = 1, message = "Amount must be greater than 0.")
    @NotNull(message = "Amount must not be null.")
    @NotBlank(message = "Amount must not be blank.")
    private Double amount;
    @Min(value = 1, message = "Income day of each month must be greater than 0.")
    @Max(value = 31, message = "Income day of each month must be less than 32.")
    @NotBlank(message = "Income day of each month must not be blank.")
    @NotNull(message = "Income day of each month must not be null.")
    private int regularFlowDayOfEachMonth;
}
