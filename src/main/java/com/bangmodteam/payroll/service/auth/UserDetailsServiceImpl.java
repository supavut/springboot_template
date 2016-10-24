package com.bangmodteam.payroll.service.auth;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bangmodteam.payroll.entity.Role;
import com.bangmodteam.payroll.entity.User;
import com.bangmodteam.payroll.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try{
			User user = userRepository.findByUsername(username);
			Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
			if(user != null){
				for (Role role : user.getRoles()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
				}
			}

			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					grantedAuthorities);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			throw ex; 
		}
		
	}

}
