package com.javaproject.EventManagement.service;

import java.util.List;

import com.javaproject.EventManagement.entities.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public User save(User theUser);
	
	public void deleteById(int theId);
	
	public User updateUser(User theUser,int id);

}
