package com.javaproject.EventManagement.dao;

import java.util.List;

import com.javaproject.EventManagement.entities.Booking;
import com.javaproject.EventManagement.entities.User;

public interface UserDAO {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public User save(User theUser);
	
	public void deleteById(int theId);
	
	public User updateUser(User theUser,int id);

	
}
