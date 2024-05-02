package com.javaproject.EventManagement.service;

import java.util.List;

import com.javaproject.EventManagement.entities.Ticket;

public interface TicketService {

	public List<Ticket> findAll();
	
	public Ticket findById(int theId);
	
	public Ticket save(Ticket theTicket);
	
	public void deleteById(int theId);
	
	public Ticket updateTicket(Ticket theTicket,int id);

}
