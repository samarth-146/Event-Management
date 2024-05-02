package com.javaproject.EventManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaproject.EventManagement.entities.Booking;
import com.javaproject.EventManagement.entities.Ticket;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class TicketDAOJpaImpl implements TicketDAO {

	private EntityManager entityManager;
	
	@Autowired
	public TicketDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Ticket> findAll() {

		TypedQuery<Ticket> theQuery = entityManager.createQuery("from Ticket", Ticket.class);
		
		List<Ticket> tickets = theQuery.getResultList();	
		return tickets;
	}

	@Override
	public Ticket findById(int theId) {

		Ticket theTicket = entityManager.find(Ticket.class, theId);
		return theTicket;
	}

	@Override
	public Ticket save(Ticket theTicket) {
		
		Ticket ticket = entityManager.merge(theTicket);
		return ticket;	}
	
	@Override
	public Ticket updateTicket(Ticket theTicket,int id)
	{
		Ticket ticket=entityManager.merge(theTicket);
		return ticket;
	}


	@Override
	public void deleteById(int theId) {

		Query theQuery = entityManager.createQuery("delete from Ticket where id=:ticketId");
		
		theQuery.setParameter("ticketId", theId);
		theQuery.executeUpdate();
	}
}
