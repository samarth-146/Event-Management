package com.javaproject.EventManagement.entities;

import java.util.Date;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.DATE)
	private Date booking_date;
	private int ticket_quantity;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_booking_id")
	private User booking;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="booking_event_id",nullable=false)
	private Event event;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public int getTicket_quantity() {
		return ticket_quantity;
	}
	public void setTicket_quantity(int ticket_quantity) {
		this.ticket_quantity = ticket_quantity;
	}
	public User getBooking() {
		return booking;
	}
	public void setBooking(User booking) {
		this.booking = booking;
	}
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public Booking(int id, Date booking_date, int ticket_quantity, User booking, Event event) {
		super();
		this.id = id;
		this.booking_date = booking_date;
		this.ticket_quantity = ticket_quantity;
		this.booking = booking;
		this.event = event;
	}
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", booking_date=" + booking_date + ", ticket_quantity=" + ticket_quantity
				+ ", booking=" + booking + ", event=" + event + "]";
	}


	
	

}
