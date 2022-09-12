package com.jpa.test.jpademo.service;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.test.jpademo.entity.User;
 
public interface UserRepository extends JpaRepository<User, Long>
{

}
