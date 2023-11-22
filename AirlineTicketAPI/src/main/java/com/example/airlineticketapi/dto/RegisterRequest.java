package com.example.airlineticketapi.dto;

public class RegisterRequest
{
    public String username;
    public String fullName;
    public String email;
    public String password;

    public RegisterRequest(String username, String fullName, String email, String password)
    {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }
}
