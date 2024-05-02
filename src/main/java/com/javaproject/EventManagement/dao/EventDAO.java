package com.javaproject.EventManagement.dao;

import java.util.List;

import com.javaproject.EventManagement.entities.Event;

public interface EventDAO {

	public List<Event> findAll();
	
	public Event findById(int theId);
	
	public Event save(Event theEvent);
	
	public void deleteById(int theId);
	
	public Event updateEvent(Event theEvent,int id);

	
}
