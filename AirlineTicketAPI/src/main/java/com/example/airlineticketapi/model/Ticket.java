package com.example.airlineticketapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    public long ticket_id;

    @ManyToOne
    @JoinColumn(name = "flight_id", referencedColumnName = "flight_id")
    public Flight flight;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    public Customer customer;

    public Ticket()
    {
    }

    public Ticket(Flight flight, Customer customer)
    {
        this.flight = flight;
        this.customer = customer;
    }
}
