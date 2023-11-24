package com.example.airlineticketapi.service;

import com.example.airlineticketapi.configuration.AuthProvider;
import com.example.airlineticketapi.dto.LoginRequest;
import com.example.airlineticketapi.dto.LoginResponse;
import com.example.airlineticketapi.dto.RegisterRequest;
import com.example.airlineticketapi.dto.RegisterResponse;
import com.example.airlineticketapi.model.Customer;
import com.example.airlineticketapi.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService
{
    private final ICustomerRepository customerRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthProvider authProvider;
    private final JwtService jwtService;

    @Autowired
    public AuthenticationService(ICustomerRepository customerRepository,
                                 BCryptPasswordEncoder passwordEncoder,
                                 JwtService jwtService, AuthProvider authProvider)
    {
        this.authProvider = authProvider;
        this.jwtService = jwtService;
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public RegisterResponse register(RegisterRequest registerRequest)
    {
        try
        {
            String password = passwordEncoder.encode(registerRequest.password);
            Customer customer = new Customer(registerRequest.username, registerRequest.fullName, registerRequest.email, password);
            customerRepository.save(customer);

            return new RegisterResponse(true, "Please login the system!");
        }
        catch (Exception ex)
        {
            return new RegisterResponse(false, "Register operation failed!");
        }
    }


    public LoginResponse login(LoginRequest loginRequest)
    {
        try
        {
            Authentication authResponse = authProvider.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.username, loginRequest.password));

            if (authResponse.isAuthenticated())
                return new LoginResponse(true, jwtService.generateToken(loginRequest.username));
            return new LoginResponse(false, null);

        }
        catch (Exception ex)
        {
            return new LoginResponse(false, null);
        }
    }
}
