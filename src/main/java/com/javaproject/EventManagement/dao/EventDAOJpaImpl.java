package com.javaproject.EventManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.javaproject.EventManagement.entities.Event;
import com.javaproject.EventManagement.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class EventDAOJpaImpl implements EventDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EventDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Event> findAll() {

		TypedQuery<Event> theQuery = entityManager.createQuery("from Event", Event.class);
		
		List<Event> events = theQuery.getResultList();	
		return events;
	}

	@Override
	public Event findById(int theId) {

		Event theEvent = entityManager.find(Event.class, theId);
		
		return theEvent;
	}

	@Override
	public Event save(Event theEvent) {
	
		return entityManager.merge(theEvent);
						
	}
	
	@Override
	public Event updateEvent(Event theEvent,int id)
	{
		Event event=entityManager.merge(theEvent);
		return event;	
	}


	@Override
	public void deleteById(int theId) {

		Query theQuery = entityManager.createQuery("delete from Event where id=:eventId");		
		theQuery.setParameter("eventId", theId);	
		theQuery.executeUpdate();
	}
}