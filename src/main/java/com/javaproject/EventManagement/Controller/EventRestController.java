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
import com.javaproject.EventManagement.service.EventService;

@RestController
@RequestMapping("/event")
public class EventRestController {

	private EventService eventService;
	
	@Autowired
	public EventRestController(EventService theEventService) {
		eventService = theEventService;
	}
	
	@GetMapping("/events")
	public List<Event> findAll() {
		return eventService.findAll();
	}

	
	@GetMapping("/events/{eventId}")
	public Event getEvent(@PathVariable int eventId) {
		
		Event theEvent = eventService.findById(eventId);
		
		if (theEvent == null) {
			throw new RuntimeException("Event id not found - " + eventId);
		}
		
		return theEvent;
	}
	
	
	@PostMapping("/events")
	public Event addEvent(@RequestBody Event theEvent) {
				
		return eventService.save(theEvent);
		
	}
		
	@PutMapping("/events/{id}")
	public Event updateEvent(@RequestBody Event theEvent,@PathVariable int id) {
		
		eventService.updateEvent(theEvent,id);
		
		return theEvent;
	}
		
	@DeleteMapping("/events/{eventId}")
	public String deleteEvent(@PathVariable int eventId) {
		
		Event tempEvent = eventService.findById(eventId);
		
		
		if (tempEvent == null) {
			throw new RuntimeException("Booking id not found - " + eventId);
		}
		
		eventService.deleteById(eventId);
		
		return "Deleted event id - " + eventId;
	}
	
}
