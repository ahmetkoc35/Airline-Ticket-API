package com.example.airlineticketapi.dto;

public class FlightDTO
{
    public String message;
    public long flight_id;

    public FlightDTO(String message, long flight_id)
    {
        this.message = message;
        this.flight_id = flight_id;
    }
}
