package com.demo.pocketpal.controller;
import com.demo.pocketpal.dto.request.IrregularFlowRequestDto;
import com.demo.pocketpal.dto.request.RegularFlowRequestDto;
import com.demo.pocketpal.dto.response.PersonInfoResponseDto;
import com.demo.pocketpal.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Person")
public class PersonController {
    private final PersonService personService;
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @GetMapping("/test")
    public String getTestString(){
        return "Auth test";
    }
    @GetMapping("/test2")
    public String getTest2String(){
        return "Auth test without authority";
    }
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/createRegularExpense")
    public ResponseEntity<Boolean> createRegularExpense(RegularFlowRequestDto dto){
        return ResponseEntity.ok(personService.createRegularExpense(dto));
    }
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/createRegularIncome")
    public ResponseEntity<Boolean> createRegularIncome(RegularFlowRequestDto dto){
        return ResponseEntity.ok(personService.createRegularIncome(dto));
    }
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/createIrregularExpense")
    public ResponseEntity<Boolean> createIrregularExpense(IrregularFlowRequestDto dto){
        return ResponseEntity.ok(personService.createIrregularExpense(dto));
    }
    @PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
    @PostMapping("/createIrregularIncome")
    public ResponseEntity<Boolean> createIrregularIncome(IrregularFlowRequestDto dto){
        return ResponseEntity.ok(personService.createIrregularIncome(dto));
    }
    @GetMapping("/getPersonInfo")
    public ResponseEntity<PersonInfoResponseDto> getPersonInfo(@RequestParam String email){
        return ResponseEntity.ok(personService.getPersonInfoWithEmail(email));
    }
}
