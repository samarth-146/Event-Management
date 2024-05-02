package com.javaproject.EventManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproject.EventManagement.entities.Event;
import com.javaproject.EventManagement.entities.Ticket;
import com.javaproject.EventManagement.entities.User;
import com.javaproject.EventManagement.service.EventServiceImpl;
import com.javaproject.EventManagement.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketRestController {

	private TicketService ticketService;
	
	@Autowired
	private EventServiceImpl eventService;
	
	@Autowired
	public TicketRestController(TicketService theTicketService) {
		ticketService = theTicketService;
	}
	
	@GetMapping("/tickets")
	public List<Ticket> findAll() {
		return ticketService.findAll();
	}

	
	@GetMapping("/tickets/{ticketId}")
	public Ticket getTicket(@PathVariable int ticketId) {
		
		Ticket theTicket = ticketService.findById(ticketId);
		
		if (theTicket == null) {
			throw new RuntimeException("Ticket id not found - " + ticketId);
		}
		
		return theTicket;
	}
	
	
	@PostMapping("/tickets")
	public Ticket addTicket(@RequestBody Ticket theTicket) {
		
		Event event = eventService.findById(theTicket.getTicket().getId());
		theTicket.setTicket(event);
		ticketService.save(theTicket);
		return theTicket;		
	}
	
	
	@PutMapping("/tickets/{id}")
	public Ticket updateTicket(@RequestBody Ticket theTicket,@PathVariable int id) {
		Event event=eventService.findById(theTicket.getTicket().getId());
		theTicket.setTicket(event);
		ticketService.updateTicket(theTicket,id);
		return theTicket;
	}
	
	
	@DeleteMapping("/tickets/{ticketId}")
	public String deleteTicket(@PathVariable int ticketId) {
		
		Ticket tempTicket = ticketService.findById(ticketId);
		
		
		if (tempTicket == null) {
			throw new RuntimeException("Ticket id not found - " + ticketId);
		}
		
		ticketService.deleteById(ticketId);
		
		return "Deleted ticket id - " + ticketId;
	}
	
}
