package com.deloitte.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {
	public List<Customer> findByRestaurantID(Integer restaurantID);
}
