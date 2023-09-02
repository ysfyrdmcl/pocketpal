package com.demo.pocketpal.controller;

import com.demo.pocketpal.dto.request.LoginRequestDto;
import com.demo.pocketpal.dto.request.RegisterRequestDto;
import com.demo.pocketpal.dto.response.AuthenticationResponseDto;
import com.demo.pocketpal.dto.response.RegisterResponseDto;
import com.demo.pocketpal.services.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/register")
    ResponseEntity<RegisterResponseDto> createPerson(@RequestBody RegisterRequestDto dto) {
        return ResponseEntity.ok(authService.createPerson(dto));
    }
    @PostMapping("/login")
    ResponseEntity<AuthenticationResponseDto>login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(authService.login(dto));
    }
}
