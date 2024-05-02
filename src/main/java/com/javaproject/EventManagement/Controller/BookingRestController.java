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

import com.javaproject.EventManagement.entities.Booking;
import com.javaproject.EventManagement.entities.User;
import com.javaproject.EventManagement.service.BookingService;
import com.javaproject.EventManagement.service.UserServiceImpl;

import com.javaproject.EventManagement.entities.Event;

import com.javaproject.EventManagement.service.*;
@RestController
@RequestMapping("/booking")
public class BookingRestController {

	private BookingService bookingService;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private EventServiceImpl eventService;
	@Autowired
	public BookingRestController(BookingService theBookingService) {
		bookingService = theBookingService;
	}
	
	@GetMapping("/bookings")
	public List<Booking> findAll() {
		return bookingService.findAll();
	}
	
	@GetMapping("/bookings/{bookingId}")
	public Booking getBooking(@PathVariable int bookingId) {
		
		Booking theBooking = bookingService.findById(bookingId);
		
		if (theBooking == null) {
			throw new RuntimeException("Booking id not found - " + bookingId);
		}
		
		return theBooking;
	}
	

	
	@PostMapping("/bookings")
	public Booking addBooking(@RequestBody Booking theBooking) {
	    // Retrieve the user associated with the booking from the database
	    User user = userService.findById(theBooking.getBooking().getId());
	    Event event=eventService.findById(theBooking.getEvent().getId());
	    // Check if the user exists and the password is provided
	    if (user == null) {
	        throw new RuntimeException("User with ID " + theBooking.getBooking().getId() + " does not exist");
	    } else if (theBooking.getBooking().getPassword() == null) {
	        throw new RuntimeException("Password not provided for user with ID " + theBooking.getBooking().getId());
	    } else if (!theBooking.getBooking().getPassword().equals(user.getPassword())) {
	        throw new RuntimeException("Incorrect password for user with ID " + theBooking.getBooking().getId());
	    }
	    
	    // Associate the retrieved user with the booking
	    theBooking.setBooking(user);
	    theBooking.setEvent(event);
	    // Save the booking
	    bookingService.save(theBooking);
	    
	    return theBooking;
	}

		
	@PutMapping("/bookings/{id}")
	public Booking updateBooking(@RequestBody Booking theBooking,@PathVariable int id) {
		User user=userService.findById(theBooking.getBooking().getId());
		theBooking.setBooking(user);
		bookingService.updateUser(theBooking, id);	
		return theBooking;
	}
	
	
	@DeleteMapping("/bookings/{bookingId}")
	public String deleteBooking(@PathVariable int bookingId) {
		
		Booking tempBooking = bookingService.findById(bookingId);
				
		if (tempBooking == null) {
			throw new RuntimeException("Booking id not found - " + bookingId);
		}
		
		bookingService.deleteById(bookingId);
		
		return "Deleted booking id - " + bookingId;
	}
	
}










