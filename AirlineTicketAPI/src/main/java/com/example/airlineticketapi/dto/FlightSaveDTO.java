package com.example.airlineticketapi.dto;

import java.time.LocalDate;

public class FlightSaveDTO
{
    public LocalDate flight_date;
    public String from_location;
    public String to_location;

    public int seat_count;
    public double price;

    public FlightSaveDTO(LocalDate flight_date, String from_location, String to_location, int seat_count, double price)
    {
        this.flight_date = flight_date;
        this.from_location = from_location;
        this.to_location = to_location;
        this.seat_count = seat_count;
        this.price = price;
    }
}
