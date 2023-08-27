package com.demo.pocketpal.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class IrregularFlowRequestDto {
    @Size(min = 3, message = "Name must be valid.")
    @NotNull(message = "Name must not be null.")
    @NotBlank(message = "Name must not be blank.")
    private String name;
    @Min(value = 1, message = "Amount must be greater than 0.")
    @NotNull(message = "Amount must not be null.")
    @NotBlank(message = "Amount must not be blank.")
    private Double amount;
    @NotNull(message = "Date must not be null.")
    @NotBlank(message = "Date must not be blank.")
    private LocalDate date;
}
