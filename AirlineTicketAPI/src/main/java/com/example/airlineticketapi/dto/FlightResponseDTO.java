package com.example.airlineticketapi.dto;

import com.example.airlineticketapi.model.Flight;

import java.util.List;

public class FlightResponseDTO
{
    public int current_page;
    public int total_page;
    public List<Flight> flights;

    public FlightResponseDTO(int current_page, int total_page, List<Flight> flights)
    {
        this.current_page = current_page;
        this.total_page = total_page;
        this.flights = flights;
    }
}
