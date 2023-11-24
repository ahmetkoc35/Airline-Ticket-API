package com.example.airlineticketapi.dto;

public class LoginResponse
{
    public String token;
    public boolean isSuccess;

    public LoginResponse( boolean isSuccess, String token)
    {
        this.token = token;
        this.isSuccess = isSuccess;
    }
}
