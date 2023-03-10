package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Customer;
import com.deloitte.repo.ICustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private ICustomerRepo customerRepo;

	@Override
	public Customer getCustomerByID(Integer customersID) {
		return customerRepo.findById(customersID).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public List<Customer> getAllCustomersInResatuarnt(Integer restaurantID) {
		return customerRepo.findByRestaurantID(restaurantID);
	}

}
