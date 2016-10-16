package com.bangmodteam.payroll.repository;

import javax.transaction.Transactional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bangmodteam.payroll.entity.Customer;

@Transactional
@Repository
public interface CustomerRepository extends  CrudRepository<Customer, Long>, QueryDslPredicateExecutor<Customer> {
	public Customer findByFirstName(String firstName);
}
