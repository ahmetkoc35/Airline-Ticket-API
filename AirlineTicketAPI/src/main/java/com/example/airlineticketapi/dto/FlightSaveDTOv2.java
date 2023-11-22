package com.example.airlineticketapi.dto;

import java.time.LocalDate;

public class FlightSaveDTOv2
{
    public LocalDate flight_date;
    public String from_location;
    public String to_location;
    public double price;

    public FlightSaveDTOv2(LocalDate flight_date, String from_location, String to_location, double price)
    {
        this.flight_date = flight_date;
        this.from_location = from_location;
        this.to_location = to_location;
        this.price = price;
    }
}
