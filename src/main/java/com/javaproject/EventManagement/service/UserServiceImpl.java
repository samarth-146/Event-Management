package com.javaproject.EventManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaproject.EventManagement.dao.UserDAO;
import com.javaproject.EventManagement.entities.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	@Autowired
	public UserServiceImpl(@Qualifier("userDAOJpaImpl") UserDAO theUserDAO) {
		userDAO = theUserDAO;
	}
	
	@Override
	@Transactional
	public List<User> findAll() {
		return userDAO.findAll();
	}

	@Override
	@Transactional
	public User findById(int theId) {
		return userDAO.findById(theId);
	}

	@Override
	@Transactional
	public User save(User theUser) {
		return userDAO.save(theUser);
	}
	
	@Override
	@Transactional
	public User updateUser(User theUser,int id)
	{
		return userDAO.updateUser(theUser,id);
	}
	@Override
	@Transactional
	public void deleteById(int theId) {
		userDAO.deleteById(theId);
	}
}
