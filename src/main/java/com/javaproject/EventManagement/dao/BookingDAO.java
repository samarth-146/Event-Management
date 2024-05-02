package com.javaproject.EventManagement.dao;

import java.util.List;

import com.ddu.ce.springbootrestwithjpa.entity.Employee;
import com.javaproject.EventManagement.entities.Booking;

public interface BookingDAO {

	public List<Booking> findAll();
	
	public Booking findById(int theId);
	
	public Booking save(Booking theBooking);
	
	public void deleteById(int theId);
	
	public Booking updateUser(Booking theBooking,int id);
	
}
