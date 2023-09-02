package com.demo.pocketpal.controller;

import com.demo.pocketpal.dto.request.IrregularFlowRequestDto;
import com.demo.pocketpal.dto.request.RegularFlowRequestDto;
import com.demo.pocketpal.dto.response.IrregularFlowResponseDto;
import com.demo.pocketpal.dto.response.PersonInfoResponseDto;
import com.demo.pocketpal.dto.response.RegularFlowResponseDto;
import com.demo.pocketpal.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
@CrossOrigin(origins = "*")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/test")
    public String getTestString() {
        return "person test";
    }

    @PostMapping("/createRegularExpense")
    public ResponseEntity<Boolean> createRegularExpense(@RequestBody RegularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.createRegularExpense(dto));
    }

    @PostMapping("/deleteRegularExpense")
    public ResponseEntity<Boolean> deleteRegularExpense(@RequestParam Long id) {
        return ResponseEntity.ok(personService.deleteRegularExpense(id));
    }

    @PostMapping("/updateRegularExpense")
    public ResponseEntity<RegularFlowResponseDto> updateRegularExpense(@RequestParam Long id, @RequestBody RegularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.updateRegularExpense(id, dto));
    }

    @PostMapping("/createRegularIncome")
    public ResponseEntity<Boolean> createRegularIncome(@RequestBody RegularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.createRegularIncome(dto));
    }

    @PostMapping("/deleteRegularIncome")
    public ResponseEntity<Boolean> deleteRegularIncome(@RequestParam Long id) {
        return ResponseEntity.ok(personService.deleteRegularIncome(id));
    }

    @PostMapping("/updateRegularIncome")
    public ResponseEntity<RegularFlowResponseDto> updateRegularIncome(@RequestParam Long id, @RequestBody RegularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.updateRegularIncome(id, dto));
    }

    @PostMapping("/createIrregularExpense")
    public ResponseEntity<Boolean> createIrregularExpense(@RequestBody IrregularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.createIrregularExpense(dto));
    }

    @PostMapping("/deleteIrregularExpense")
    public ResponseEntity<Boolean> deleteIrregularExpense(@RequestParam Long id) {
        return ResponseEntity.ok(personService.deleteIrregularExpense(id));
    }

    @PostMapping("/updateIrregularExpense")
    public ResponseEntity<IrregularFlowResponseDto> updateIrregularExpense(@RequestParam Long id, @RequestBody IrregularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.updateIrregularExpense(id, dto));
    }

    @PostMapping("/createIrregularIncome")
    public ResponseEntity<Boolean> createIrregularIncome(@RequestBody IrregularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.createIrregularIncome(dto));
    }

    @PostMapping("/deleteIrregularIncome")
    public ResponseEntity<Boolean> deleteIrregularIncome(@RequestParam Long id) {
        return ResponseEntity.ok(personService.deleteIrregularIncome(id));
    }

    @PostMapping("/updateIrregularIncome")
    public ResponseEntity<IrregularFlowResponseDto> updateIrregularIncome(@RequestParam Long id, @RequestBody IrregularFlowRequestDto dto) {
        return ResponseEntity.ok(personService.updateIrregularIncome(id, dto));
    }

    @GetMapping("/getPersonInfo")
    public ResponseEntity<PersonInfoResponseDto> getPersonInfo(@RequestParam String email) {
        return ResponseEntity.ok(personService.getPersonInfoWithEmail(email));
    }
}
