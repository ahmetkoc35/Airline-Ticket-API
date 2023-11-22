package com.example.airlineticketapi.dto;

import java.time.LocalDate;

public class FlightDateAndLocationQueryDTO
{
    public LocalDate start_date;
    public LocalDate end_date;
    public String from_location;
    public String to_location;
    public int page;


    public FlightDateAndLocationQueryDTO(LocalDate start_date, LocalDate end_date, String from_location, String to_location, int page)
    {
        this.start_date = start_date;
        this.end_date = end_date;
        this.from_location = from_location;
        this.to_location = to_location;
        this.page = page;
    }
}
