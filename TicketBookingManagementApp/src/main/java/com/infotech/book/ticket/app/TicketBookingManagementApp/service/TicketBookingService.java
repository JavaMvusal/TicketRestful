package com.infotech.book.ticket.app.TicketBookingManagementApp.service;

import com.infotech.book.ticket.app.TicketBookingManagementApp.dao.TicketBookingDao;
import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketBookingService {
    @Autowired
    private TicketBookingDao ticketBookingDao;

    public Ticket createTicket(Ticket ticket) {
       return ticketBookingDao.save(ticket);
    }

    public Ticket getTicketById(Integer id) {
    return ticketBookingDao.findById(id).get();
    }

    public Iterable<Ticket> getAllTickets() {
    return ticketBookingDao.findAll();
    }

    public String deleteTicketById(Integer id) {
    if(!ticketBookingDao.existsById(id)){
        return "Not found id for deleting";
    }
    ticketBookingDao.deleteById(id);
    return "Deleted succesfully";
    }

    public Ticket updateTicket(Integer id, Ticket newTicket) {
    Optional<Ticket> tickett = ticketBookingDao.findById(id);//id in which database equals to Optinal interface ticket
   return tickett.map(ticket->{
    ticket.setPassengerName(newTicket.getPassengerName());
    ticket.setEmail(newTicket.getEmail());
    ticket.setSourceStation(newTicket.getSourceStation());
    ticket.setBookingDate(newTicket.getBookingDate());
    ticket.setDestStation(newTicket.getDestStation());
    return ticketBookingDao.save(ticket);
    }).orElseGet(() -> {
            newTicket.setTicketId(id);
    return ticketBookingDao.save(newTicket);});
        }
}
