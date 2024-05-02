
package com.javaproject.EventManagement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private int ticket_price;
	private int quantityAvalable;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="event_ticket_id")
	private Event ticket;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", type=" + type + ", ticket_price=" + ticket_price + ", quantityAvalable="
				+ quantityAvalable + ", ticket=" + ticket + "]";
	}
	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ticket(int id, String type, int ticket_price, int quantityAvalable, Event ticket) {
		super();
		this.id = id;
		this.type = type;
		this.ticket_price = ticket_price;
		this.quantityAvalable = quantityAvalable;
		this.ticket = ticket;
	}
	public int getTicket_price() {
		return ticket_price;
	}
	public void setTicket_price(int ticket_price) {
		this.ticket_price = ticket_price;
	}
	public int getQuantityAvalable() {
		return quantityAvalable;
	}
	public void setQuantityAvalable(int quantityAvalable) {
		this.quantityAvalable = quantityAvalable;
	}
	public Event getTicket() {
		return ticket;
	}
	public void setTicket(Event ticket) {
		this.ticket = ticket;
	}
	
	
	
	
}
