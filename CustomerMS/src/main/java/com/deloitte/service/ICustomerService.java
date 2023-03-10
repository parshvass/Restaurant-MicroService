package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Customer;

public interface ICustomerService {
	public Customer getCustomerByID(Integer customersID);

	public List<Customer> getAllCustomers();

	public List<Customer> getAllCustomersInResatuarnt(Integer restaurantID);

}
