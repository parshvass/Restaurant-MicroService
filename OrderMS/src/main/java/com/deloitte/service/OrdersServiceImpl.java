package com.deloitte.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Orders;
import com.deloitte.repo.IOrdersRepo;

/*
	create a method in realTime to create order calculate AmountDue and prepTime and Date Placed ON
	
*/

@Service
public class OrdersServiceImpl implements IOrdersService {
	@Autowired
	private IOrdersRepo ordersRepo;

	@Override
	public List<Orders> fetchAllOrders() {
		return ordersRepo.findAll();
	}

	@Override
	public Integer fetchPrepTime(Integer orderID) {
		return ordersRepo.findById(orderID).get().getOrderedFoodID();
	}

	@Override
	public Boolean orderIsPaid(Integer orderID) {
		return ordersRepo.findById(orderID).get().getOrdersIsPaid();
	}

	@Override
	public Double orderAmount(Integer orderID) {
		return ordersRepo.findById(orderID).get().getOrdersAmountDue();
	}

	@Override
	public Orders fetchOrderByOrderID(Integer orderID) {
		return ordersRepo.findById(orderID).get();
	}

	@Override
	public List<Orders> fetchOrderByCustomerID(Integer customerID) {
		return ordersRepo.findByCustomerID(customerID);
	}

	@Override
	public List<Integer> getAllCustomersWithDues() {
		List<Orders> unpaidOrders = ordersRepo.findByOrdersIsPaid(false);
		List<Integer> customersWithDue = new ArrayList<Integer>();
		for(Orders orders: unpaidOrders) {
			customersWithDue.add(orders.getCustomerID());
		}
		customersWithDue = customersWithDue.stream().distinct().toList();
		System.out.println("customersWithDue"+customersWithDue);
		return customersWithDue ;
		
		
	}

}
