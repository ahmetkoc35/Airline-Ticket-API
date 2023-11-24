package com.example.airlineticketapi.dto;

import java.time.LocalDate;

public class TicketDTO
{
    public long flight_no;
    public int seat_number;
    public LocalDate date;
    public String from;
    public String to;
    public double price;
    public String message;


    public TicketDTO(String message)
    {
        this.message = message;
        from = null;
        to = null;
        date = null;
    }

    public TicketDTO(long flight_no, int seat_number, LocalDate date, String from, String to, double price, String message)
    {
        this.flight_no = flight_no;
        this.seat_number = seat_number;
        this.date = date;
        this.from = from;
        this.to = to;
        this.price = price;
        this.message = message;
    }
}
