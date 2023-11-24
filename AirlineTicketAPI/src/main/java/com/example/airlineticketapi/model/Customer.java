package com.example.airlineticketapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    public long customer_id;
    @Column(name = "username", unique = true)
    public String username;
    @Column(name = "full_name")
    public String full_name;
    @Column(name = "email", unique = true)
    public String email;
    @Column(name = "password")
    public String password;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    public Set<Ticket> tickets;

    public Customer()
    {
    }

    public Customer(String username, String full_name, String email, String password)
    {
        this.username = username;
        this.full_name = full_name;
        this.email = email;
        this.password = password;
    }

    public void addTicket(Ticket ticket)
    {
        if (tickets == null)
            tickets = new HashSet<>();

        tickets.add(ticket);
    }
}
