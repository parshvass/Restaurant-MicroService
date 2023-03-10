package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Orders;

public interface IOrdersService {
	public List<Orders> fetchAllOrders();
	
	public Integer fetchPrepTime(Integer orderID);
	
	public Boolean orderIsPaid(Integer orderID);
	
	public Double orderAmount(Integer orderID);
	
	public Orders fetchOrderByOrderID(Integer orderID);
	
	public List<Orders> fetchOrderByCustomerID(Integer customerID);
	
	public List<Integer> getAllCustomersWithDues();
}
