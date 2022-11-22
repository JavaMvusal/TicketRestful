package com.infotech.book.ticket.app.TicketBookingManagementApp.controller;

import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import com.infotech.book.ticket.app.TicketBookingManagementApp.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {
    @Autowired
    private TicketBookingService ticketBookingService;

    @PostMapping(value = "/create")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketBookingService.createTicket(ticket);
    }
    @GetMapping("/{id}")
    public Ticket getTicketById(@PathVariable("id") Integer id){
        return ticketBookingService.getTicketById(id);
    }
    @GetMapping("/all")
    public Iterable<Ticket> getAllTickets(){
        return ticketBookingService.getAllTickets();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTicketById(@PathVariable("id") Integer id){
       return ticketBookingService.deleteTicketById(id);
    }
    @PutMapping("/update/{id}")
    public Ticket updateTicket(@PathVariable("id") Integer id,@RequestBody Ticket newTicket){
        return ticketBookingService.updateTicket(id,newTicket);
    }

}
