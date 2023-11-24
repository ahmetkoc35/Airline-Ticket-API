package com.example.airlineticketapi.controller;

import com.example.airlineticketapi.dto.TicketBuyDTO;
import com.example.airlineticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/ticket")
public class TicketController
{
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService)
    {
        this.ticketService = ticketService;
    }

    @PostMapping("/buy")
    public Object buyTicket(@RequestBody TicketBuyDTO ticketBuyDTO)
    {
        return ticketService.buyTicket(ticketBuyDTO);
    }
}
