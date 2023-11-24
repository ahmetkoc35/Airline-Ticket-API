package com.example.airlineticketapi.dto;


import java.time.LocalDate;

public class FlightQueryDTO
{
    public LocalDate start_date;
    public LocalDate end_date;

    public String from_location;
    public String to_location;
    public double min_price;
    public double max_price;
    public int page;

    public FlightQueryDTO(LocalDate start_date, LocalDate end_date, String from_location, String to_location, double min_price, double max_price, int page)
    {
        this.start_date = start_date;
        this.end_date = end_date;
        this.from_location = from_location;
        this.to_location = to_location;
        this.min_price = min_price;
        this.max_price = max_price;
        this.page = page;
    }
}
