package com.example.jwt_secure.service.auth.impl;

import com.example.jwt_secure.domain.api.Role;
import com.example.jwt_secure.domain.api.UserDetailsImpl;
import com.example.jwt_secure.domain.api.authRequest.AuthenticationRequest;
import com.example.jwt_secure.domain.api.authRequest.RegistrationRequest;
import com.example.jwt_secure.domain.api.authResponse.AuthenticationResponse;
import com.example.jwt_secure.dto.entity.User;
import com.example.jwt_secure.dto.repository.UserRepo;
import com.example.jwt_secure.service.auth.AuthService;
import com.example.jwt_secure.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse registration(RegistrationRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER).build();
        userRepo.save(user);
        UserDetailsImpl userDetails = UserDetailsImpl.builder().user(user).build();
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    @Override
    public AuthenticationResponse authentication(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = userRepo.findByUsername(request.getUsername());
        UserDetailsImpl userDetails = UserDetailsImpl.builder().user(user).build();
        String jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
