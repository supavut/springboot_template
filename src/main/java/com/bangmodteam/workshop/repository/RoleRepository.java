package com.bangmodteam.workshop.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bangmodteam.workshop.entity.Role;
@Transactional
@Repository
public interface RoleRepository extends  CrudRepository<Role, Long> {

}
