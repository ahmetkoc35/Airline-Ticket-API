package com.example.airlineticketapi.controller;

import com.example.airlineticketapi.dto.LoginRequest;
import com.example.airlineticketapi.dto.LoginResponse;
import com.example.airlineticketapi.dto.RegisterRequest;
import com.example.airlineticketapi.dto.RegisterResponse;
import com.example.airlineticketapi.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController
{
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService)
    {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest)
    {
        return authenticationService.login(loginRequest);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request)
    {
        return authenticationService.register(request);
    }
}
