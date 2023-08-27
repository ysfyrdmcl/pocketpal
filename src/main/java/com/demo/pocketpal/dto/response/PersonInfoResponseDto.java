package com.demo.pocketpal.dto.response;

import com.demo.pocketpal.entitiy.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonInfoResponseDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;

    private List<RegularFlowResponseDto> regularExpenses;

    private List <RegularFlowResponseDto> regularIncomes;

    private List <IrregularFlowResponseDto> irregularExpenses;

    private List <IrregularFlowResponseDto> irregularIncomes;
}
