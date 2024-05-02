package com.javaproject.EventManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ddu.ce.springbootrestwithjpa.dao.EmployeeDAO;
import com.ddu.ce.springbootrestwithjpa.entity.Employee;
import com.javaproject.EventManagement.dao.BookingDAO;
import com.javaproject.EventManagement.entities.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingDAO bookingDAO;
	
	@Autowired
	public BookingServiceImpl(@Qualifier("bookingDAOJpaImpl") BookingDAO theBookingDAO) {
		bookingDAO = theBookingDAO;
	}
	
	@Override
	@Transactional
	public List<Booking> findAll() {
		return bookingDAO.findAll();
	}

	@Override
	@Transactional
	public Booking findById(int theId) {
		return bookingDAO.findById(theId);
	}

	@Override
	@Transactional
	public Booking save(Booking theBooking) {
		return bookingDAO.save(theBooking);
	}
	
	@Override
	@Transactional
	public Booking updateUser(Booking theBooking,int id)
	{
		return bookingDAO.updateUser(theBooking, id);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		bookingDAO.deleteById(theId);
	}
}






