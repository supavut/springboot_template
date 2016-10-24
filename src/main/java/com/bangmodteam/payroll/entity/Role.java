package com.bangmodteam.payroll.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Setter
@Getter
public class Role {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
    
    @ManyToMany(mappedBy = "roles",fetch=FetchType.LAZY)
    private Set<User> users;

    
}