package com.javaproject.EventManagement.dao;

import java.util.List;

import com.javaproject.EventManagement.entities.Ticket;

public interface TicketDAO {

	public List<Ticket> findAll();
	
	public Ticket findById(int theId);
	
	public Ticket save(Ticket theEvent);
	
	public void deleteById(int theId);
	
	public Ticket updateTicket(Ticket theTicket,int id);

	
}
