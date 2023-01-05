package com.deloitte.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.deloitte.entity.Orders;
import com.deloitte.model.Food;
import com.deloitte.model.Response;
import com.deloitte.service.OrdersServiceImpl;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	final String GET_ORDER_PREP_TIME = "http://localhost:8081/food/fetchOrdersPrepTime/";
	final String GET_ORDERED_FOOD = "http://localhost:8081/food/fetchFoodByOrdersID/";

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private OrdersServiceImpl ordersService;

	@GetMapping("/fetchAllOrders")
	public List<Orders> fetchOrders() {
		return ordersService.fetchAllOrders();
	}

	@GetMapping("/fetchPrepTime/{ordersID}")
	@HystrixCommand(fallbackMethod = "fetchPrepTimeFaliureFallBack")
	public ResponseEntity<?> fetchPrepTime(@PathVariable Integer ordersID) {
		Integer prepTime = restTemplate.getForObject(GET_ORDER_PREP_TIME + ordersID, Integer.class);
		System.out.println("prepTime: " + prepTime);
		Response response = new Response(prepTime, "PrepTime:");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchPrepTimeFaliureFallBack(@PathVariable Integer orderID) {
		Integer foodID = ordersService.fetchPrepTime(orderID);
		Response response = new Response(foodID, "Food-MS is unvailable at the momentss");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/orderIsPaid/{orderID}")
	public Boolean orderIsPaid(@PathVariable Integer orderID) {
		return ordersService.orderIsPaid(orderID);
	}

	@GetMapping("/orderAmount/{orderID}")
	public Double orderAmount(@PathVariable Integer orderID) {
		return ordersService.orderAmount(orderID);
	}

	@GetMapping("/fetchOrderByID/{orderID}")
	public Orders fetchOrderByID(@PathVariable Integer orderID) {
		return ordersService.fetchOrderByOrderID(orderID);
	}

	@GetMapping("/fetchByCustomersID/{customersID}")
	public List<Orders> fetchByCustomersID(@PathVariable Integer customersID) {
		return ordersService.fetchOrderByCustomerID(customersID);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/fetchCompleteOrderByID/{ordersID}")
	@HystrixCommand(fallbackMethod = "fetchCompleteOrderByIDFallBack")
	public ResponseEntity<?> fetchCompleteOrderByID(@PathVariable Integer ordersID) {
		System.out.println("\n\n\n*******************************************");
		System.out.println("Printing list of food: ");
		List<Food> completeOrder = restTemplate.getForObject(GET_ORDERED_FOOD + ordersID, List.class);
		Iterator<Food> i = completeOrder.iterator();
		while(i.hasNext()) {
			System.out.println(i);
			i.next();
		}
		System.out.println("class of i:"+i.getClass());
		Response response = new Response(completeOrder);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	public ResponseEntity<?> fetchCompleteOrderByIDFallBack(@PathVariable Integer ordersID) {
		Response response = new Response(ordersID, "Food-MS is unvailable at the moment");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/fetchCustomersWithDues")
	public ResponseEntity<List<Integer>> fetchCustomersWithDues() {
		System.out.println("Hello");
		return new ResponseEntity<List<Integer>>(ordersService.getAllCustomersWithDues(), HttpStatus.OK);
	}
	// fetch all foods for particular order

	@GetMapping("/getCustomerRecentOrder/{customersID}")
	public Orders getCustomerRecentOrder(@PathVariable Integer customersID) {
		List<Orders> ordersList =  ordersService.fetchOrderByCustomerID(customersID);
		return null;
	}

}
