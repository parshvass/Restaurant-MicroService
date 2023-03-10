package com.deloitte.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.entity.Customer;
import com.deloitte.model.Orders;
import com.deloitte.model.Response;
import com.deloitte.service.CustomerServiceImpl;

@RequestMapping("/customers")
@RestController
public class CustomerController {
	@Autowired
	private CustomerServiceImpl customerService;

	@Autowired
	private RestTemplate restTemplate;

	final String GET_ORDERS_FOR_CUSTOMER_ID = "http://localhost:8085/orders/fetchByCustomersID/";
	final String GET_CUSTOMER_WITH_DUES = "http://localhost:8085/orders/fetchCustomersWithDues";

	@GetMapping("/getAllCustomers")
	public ResponseEntity<Response> getAllCustomers() {
		return new ResponseEntity<Response>(new Response(customerService.getAllCustomers()), HttpStatus.OK);
	}

	@GetMapping("/getCustomerByID/{customersID}")
	public ResponseEntity<Response> getCustomerByID(@PathVariable Integer customersID) {
		return new ResponseEntity<Response>(new Response(customerService.getCustomerByID(customersID)), HttpStatus.OK);
	}

	@GetMapping("/getAllOrdersForCustomer/{customersID}")
	public ResponseEntity<Response> getAllOrdersForCustomer(@PathVariable Integer customersID){
		return new ResponseEntity<Response>(new Response(restTemplate.getForObject(GET_ORDERS_FOR_CUSTOMER_ID+customersID, List.class)
), HttpStatus.OK);
	}

	@GetMapping("/getAllCustomersInResatuarnt/{restaurantID}")
	public ResponseEntity<Response> getAllCustomersInResatuarnt(@PathVariable Integer restaurantID) {
		return new ResponseEntity<Response>(new Response(customerService.getAllCustomersInResatuarnt(restaurantID)),
				HttpStatus.OK);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/getAllCustomersWithDues")
	public ResponseEntity<Response> getAllCustomersWithDues() {
		System.out.println("123");
		List<Integer> customersIDList = restTemplate.getForObject(GET_CUSTOMER_WITH_DUES, List.class);
		System.out.println("customersIDList: "+customersIDList);
		List<Customer> customerList = new ArrayList<>();
		for(Integer i:customersIDList){
			customerList.add(customerService.getCustomerByID(i));
		}
		
		return new ResponseEntity<Response>(new Response("customers with dues",customerList), HttpStatus.OK);
	}

	@GetMapping("/getCustomerRecentOrder/{customersID}")
	public ResponseEntity<Orders> getCustomerRecentOrder(@PathVariable Integer customersID) {
		@SuppressWarnings("unchecked")
		List<Orders> ordersList= restTemplate.getForObject(GET_ORDERS_FOR_CUSTOMER_ID+customersID, List.class);
//		ordersList.sort((o1, o2) -> o1.getOrderPlacedOn().compareTo(o2.getOrderPlacedOn()));
		System.out.println("ordersList: "+ordersList);
		Collections.sort(ordersList);
		System.out.println("Sorted ordersList: "+ordersList);
		Orders order = new Orders();
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
}
