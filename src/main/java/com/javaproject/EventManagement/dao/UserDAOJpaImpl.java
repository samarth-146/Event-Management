package com.javaproject.EventManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaproject.EventManagement.entities.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class UserDAOJpaImpl implements UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<User> findAll() {
		TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}

	@Override
	public User findById(int theId) {
		User theUser = entityManager.find(User.class, theId);
		return theUser;
	}

	@Override
	public User save(User theUser) {
		User user = entityManager.merge(theUser);
		return user;
		
	}
	
	@Override
	public User updateUser(User theUser,int id)
	{
		User user=entityManager.merge(theUser);
		return user;
	}


	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from User where id=:userId");	
		theQuery.setParameter("userId", theId);	
		theQuery.executeUpdate();
	}
}
