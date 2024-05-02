package com.javaproject.EventManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.EventManagement.dao.EventDAO;
import com.javaproject.EventManagement.entities.Event;

@Service
public class EventServiceImpl implements EventService {

	private EventDAO eventDAO;
	
	@Autowired
	public EventServiceImpl(@Qualifier("eventDAOJpaImpl") EventDAO theEventDAO) {
		eventDAO = theEventDAO;
	}
	
	@Override
	@Transactional
	public List<Event> findAll() {
		return eventDAO.findAll();
	}

	@Override
	@Transactional
	public Event findById(int theId) {
		return eventDAO.findById(theId);
	}

	@Override
	@Transactional
	public Event save(Event theEvent) {
		return eventDAO.save(theEvent);
	}
	
	@Override
	@Transactional
	public Event updateEvent(Event theEvent,int id)
	{
		return eventDAO.updateEvent(theEvent,id);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		eventDAO.deleteById(theId);
	}
}
