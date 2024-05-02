package com.javaproject.EventManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.EventManagement.dao.TicketDAO;
import com.javaproject.EventManagement.entities.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	private TicketDAO ticketDAO;
	
	@Autowired
	public TicketServiceImpl(@Qualifier("ticketDAOJpaImpl") TicketDAO theTicketDAO) {
		ticketDAO = theTicketDAO;
	}
	
	@Override
	@Transactional
	public List<Ticket> findAll() {
		return ticketDAO.findAll();
	}

	@Override
	@Transactional
	public Ticket findById(int theId) {
		return ticketDAO.findById(theId);
	}

	@Override
	@Transactional
	public Ticket save(Ticket theTicket) {
		return ticketDAO.save(theTicket);
	}
	
	@Override
	@Transactional
	public Ticket updateTicket(Ticket theTicket,int id)
	{
		return ticketDAO.updateTicket(theTicket,id);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ticketDAO.deleteById(theId);
	}
}
