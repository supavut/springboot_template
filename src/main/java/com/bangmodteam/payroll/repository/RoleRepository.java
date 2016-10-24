package com.bangmodteam.payroll.repository;

import javax.transaction.Transactional;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bangmodteam.payroll.entity.Role;
@Transactional
@Repository
public interface RoleRepository extends  CrudRepository<Role, Long>, QueryDslPredicateExecutor<Role> {

}
