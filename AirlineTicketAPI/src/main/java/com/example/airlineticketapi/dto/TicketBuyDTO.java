package com.example.airlineticketapi.dto;

public class TicketBuyDTO
{
    public String customer_username;
    public long flight_id;

    public TicketBuyDTO(String customer_username, long flight_id)
    {
        this.customer_username = customer_username;
        this.flight_id = flight_id;
    }
}
