package com.example.jwt_secure.controller;

import com.example.jwt_secure.domain.api.authRequest.AuthenticationRequest;
import com.example.jwt_secure.domain.api.authResponse.AuthenticationResponse;
import com.example.jwt_secure.domain.api.authRequest.RegistrationRequest;
import com.example.jwt_secure.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registration(@RequestBody RegistrationRequest request){
        return ResponseEntity.ok(authService.registration(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authService.authentication(request));
    }
}
