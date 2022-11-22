package com.infotech.book.ticket.app.TicketBookingManagementApp.dao;

import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface TicketBookingDao extends CrudRepository<Ticket,Integer> {
}
