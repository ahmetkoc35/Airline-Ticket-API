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

    public LocalDate getStart_date()
    {
        return start_date;
    }

    public void setStart_date(LocalDate start_date)
    {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date()
    {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date)
    {
        this.end_date = end_date;
    }

    public String getFrom_location()
    {
        return from_location;
    }

    public void setFrom_location(String from_location)
    {
        this.from_location = from_location;
    }

    public String getTo_location()
    {
        return to_location;
    }

    public void setTo_location(String to_location)
    {
        this.to_location = to_location;
    }

    public int getPage()
    {
        return page;
    }

    public void setPage(int page)
    {
        this.page = page;
    }
}
