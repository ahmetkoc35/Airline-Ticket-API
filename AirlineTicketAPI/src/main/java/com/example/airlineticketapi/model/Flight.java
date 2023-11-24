package com.example.airlineticketapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight")
public class Flight
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    public long flight_id;

    @Column(name = "flight_date", nullable = false)
    public LocalDate flight_date;

    @Column(name = "from_location", nullable = false)
    public String from_location;

    @Column(name = "to_location", nullable = false)
    public String to_location;

    @Column(name = "seat_count", nullable = false)
    public int seat_count;

    @Column(name = "price", nullable = false)
    public double price;


    @OneToMany(mappedBy = "flight", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Ticket> tickets;

    public Flight()
    {

    }

    public Flight(LocalDate flight_date, String from_location, String to_location, int seat_count, double price)
    {
        this.flight_date = flight_date;
        this.from_location = from_location;
        this.to_location = to_location;
        this.seat_count = seat_count;
        this.price = price;
    }

    public void addTicket(Ticket ticket)
    {
        if (tickets == null)
            tickets = new HashSet<>();

        tickets.add(ticket);
    }
}
