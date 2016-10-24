package com.bangmodteam.payroll.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bangmodteam.payroll.entity.User;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long>, QueryDslPredicateExecutor<User> {
	
	@Query("select u from User u where u.username = ?1")
	User findByUsername(String username);
}
