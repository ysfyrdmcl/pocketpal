package com.demo.pocketpal.controller;

import com.demo.pocketpal.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    private final PersonService personService;
    @PostMapping("/deletePerson")
    public ResponseEntity<Boolean> deletePerson(@RequestParam Long id) {
        return ResponseEntity.ok(personService.deletePerson(id));
    }
    @GetMapping("/test")
    public String getTestString() {
        return "Admin test";
    }
}
