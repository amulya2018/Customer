package com.servicemarket.customer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servicemarket.customer.dto.Customer;
import com.servicemarket.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@RequestMapping(method= RequestMethod.POST, value="/signup")
	public String signUp(@RequestBody Customer customer) {
		return service.signUp(customer);
	}
	
	@RequestMapping("/signin/{name}/{password}")
	public String signIn(@PathVariable String username, @PathVariable String password) {
		return service.signIn(username, password);
	}
	
	@RequestMapping("/{id}")
	Optional<Customer> getDetailsByCid(@PathVariable int id){
		return service.getDetailsByCid(id);
	}
	@RequestMapping("/email/{email}")
	String getUserByEmail(@PathVariable String email){
		return service.getUserEmail(email);
	}
	
}

