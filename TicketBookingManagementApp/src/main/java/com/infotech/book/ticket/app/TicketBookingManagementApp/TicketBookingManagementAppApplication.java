package com.infotech.book.ticket.app.TicketBookingManagementApp;

import com.infotech.book.ticket.app.TicketBookingManagementApp.entities.Ticket;
import com.infotech.book.ticket.app.TicketBookingManagementApp.service.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import javax.sql.DataSource;
import java.util.Date;

@SpringBootApplication
public class TicketBookingManagementAppApplication {



	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext =SpringApplication.run(TicketBookingManagementAppApplication.class, args);
		TicketBookingService ticketBookingService = applicationContext.getBean("ticketBookingService",TicketBookingService.class);
		Ticket ticket = new Ticket();
		ticket.setBookingDate(new Date());
		ticket.setDestStation("Baku");
		ticket.setEmail("java.vusal.mustafayev@gmail.com");
		ticket.setSourceStation("USA");
		ticket.setPassengerName("Vusal");
		ticketBookingService.createTicket(ticket);

	}

}
