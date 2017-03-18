package com.bangmodteam.workshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bangmodteam.workshop.entity.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
	@Query("select u from User u where u.username = ?1")
	User findByUsername(String username);
}
