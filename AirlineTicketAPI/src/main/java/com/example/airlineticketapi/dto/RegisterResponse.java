package com.example.airlineticketapi.dto;

public class RegisterResponse
{
    public boolean isSuccess;
    public String message;

    public RegisterResponse(boolean isSuccess, String message)
    {
        this.isSuccess = isSuccess;
        this.message = message;
    }
}
