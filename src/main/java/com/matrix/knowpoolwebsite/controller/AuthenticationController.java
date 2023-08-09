package com.matrix.knowpoolwebsite.controller;

import com.matrix.knowpoolwebsite.dto.request.AuthenticationRequest;
import com.matrix.knowpoolwebsite.dto.request.RegisterRequest;
import com.matrix.knowpoolwebsite.dto.response.AuthenticationResponseDto;
import com.matrix.knowpoolwebsite.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationServiceImpl service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseDto>register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDto>authenticate(@RequestBody AuthenticationRequest request){
        return  ResponseEntity.ok(service.authenticate(request));
    }
}
