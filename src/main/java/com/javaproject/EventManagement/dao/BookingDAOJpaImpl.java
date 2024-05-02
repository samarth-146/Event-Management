package com.javaproject.EventManagement.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ddu.ce.springbootrestwithjpa.entity.Employee;
import com.javaproject.EventManagement.entities.Booking;

@Repository
public class BookingDAOJpaImpl implements BookingDAO {

	private EntityManager entityManager;
	
	@Autowired
	public BookingDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Booking> findAll() {

		TypedQuery<Booking> theQuery = entityManager.createQuery("from Booking", Booking.class);
		List<Booking> bookings = theQuery.getResultList();		
		return bookings;
	}

	@Override
	public Booking findById(int theId) {
		Booking theBooking = entityManager.find(Booking.class, theId);
		return theBooking;
	}

	@Override
	public Booking save(Booking theBooking) {
		Booking booking = entityManager.merge(theBooking);
		return booking;
	}
	
	@Override
	public Booking updateUser(Booking theBooking,int id)
	{
		Booking booking=entityManager.merge(theBooking);
		return booking;
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Booking where id=:bookingId");	
		theQuery.setParameter("bookingId", theId);	
		theQuery.executeUpdate();
	}
}










