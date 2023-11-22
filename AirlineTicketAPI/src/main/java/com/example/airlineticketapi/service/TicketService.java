package com.example.airlineticketapi.service;

import com.example.airlineticketapi.dto.TicketBuyDTO;
import com.example.airlineticketapi.dto.TicketDTO;
import com.example.airlineticketapi.model.Customer;
import com.example.airlineticketapi.model.Flight;
import com.example.airlineticketapi.model.Ticket;
import com.example.airlineticketapi.repository.ICustomerRepository;
import com.example.airlineticketapi.repository.IFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.time.LocalDate.now;

@Service
public class TicketService
{
    private final IFlightRepository flightRepository;
    private final ICustomerRepository customerRepository;

    @Autowired
    public TicketService(IFlightRepository flightRepository, ICustomerRepository customerRepository)
    {
        this.flightRepository = flightRepository;
        this.customerRepository = customerRepository;
    }

    public TicketDTO buyTicket(TicketBuyDTO ticketBuyDTO)
    {
        try
        {
            Optional<Customer> customer = customerRepository.findCustomerByUsername(ticketBuyDTO.customer_username);
            Optional<Flight> flight = flightRepository.findById(ticketBuyDTO.flight_id);

            if (customer.isEmpty() || flight.isEmpty())
                return new TicketDTO("Please control the customer or flight information!");

            if (flight.get().seat_count <= 0 || flight.get().flight_date.isBefore(now()))
                return new TicketDTO("Please control the flight information!");

            Ticket ticket = new Ticket(flight.get(), customer.get());

            int customerSeat = flight.get().seat_count;

            flight.get().seat_count = flight.get().seat_count - 1;

            // Update customer and flight. Also save ticket.
            flightRepository.save(flight.get());
            customer.get().addTicket(ticket);
            customerRepository.save(customer.get());

            return new TicketDTO(flight.get().flight_id, customerSeat, flight.get().flight_date, flight.get().from_location,
                    flight.get().to_location, flight.get().price, "Ticket created successfully!");
        }
        catch (Exception ex)
        {
            return new TicketDTO("Something wrong in server");
        }
    }

}
