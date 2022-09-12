package com.jpa.test.jpademo.service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.test.jpademo.entity.User;
 
@Repository
@Transactional
public class UserDAOService {

	public UserDAOService() {
		// TODO Auto-generated constructor stub
	}	
	@PersistenceContext
	private EntityManager entityManager;
	public long insert(User user){
		entityManager.persist(user);
		return user.getId();
	}
}
