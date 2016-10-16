package com.bangmodteam.payroll.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bangmodteam.payroll.entity.Customer;
import com.bangmodteam.payroll.entity.QCustomer;
import com.bangmodteam.payroll.repository.CustomerRepository;
import com.querydsl.core.types.Predicate;
@Controller
public class MainController {

	@Autowired
	private CustomerRepository customerRepository;
	
	@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Model model) {
        model.addAttribute("thymeleaf", "Test thymeleaf");  
        Predicate titleIs = QCustomer.customer.firstName.eq("Foo");
        customerRepository.findAll(titleIs);
        return "thymeleaf";  
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public void create(HttpServletResponse httpServletResponse){
		Customer cus = new Customer("test","Test2");
		customerRepository.save(cus);
		try {
			httpServletResponse.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
