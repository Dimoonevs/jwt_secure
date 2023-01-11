package com.example.jwt_secure.service.auth;

import com.example.jwt_secure.domain.api.authRequest.AuthenticationRequest;
import com.example.jwt_secure.domain.api.authRequest.RegistrationRequest;
import com.example.jwt_secure.domain.api.authResponse.AuthenticationResponse;

public interface AuthService {
    AuthenticationResponse registration(RegistrationRequest request);

    AuthenticationResponse authentication(AuthenticationRequest request);
}
