package com.deloitte.model;

import java.sql.Date;

public class Orders {

	private Integer orderedFoodID;
	private Double ordersAmountDue;
	private Boolean ordersIsPaid;
	private Date orderPlacedOn;
	private Integer orderID;
	private Integer customerID;

	public Orders() {
		super();
	}

	public Orders(Integer orderedFoodID, Double ordersAmountDue, Boolean ordersIsPaid, Date orderPlacedOn,
			Integer orderID, Integer customerID) {
		super();
		this.orderedFoodID = orderedFoodID;
		this.ordersAmountDue = ordersAmountDue;
		this.ordersIsPaid = ordersIsPaid;
		this.orderPlacedOn = orderPlacedOn;
		this.orderID = orderID;
		this.customerID = customerID;
	}

	public Integer getOrderedFoodID() {
		return orderedFoodID;
	}

	public void setOrderedFoodID(Integer orderedFoodID) {
		this.orderedFoodID = orderedFoodID;
	}

	public Double getOrdersAmountDue() {
		return ordersAmountDue;
	}

	public void setOrdersAmountDue(Double ordersAmountDue) {
		this.ordersAmountDue = ordersAmountDue;
	}

	public Boolean getOrdersIsPaid() {
		return ordersIsPaid;
	}

	public void setOrdersIsPaid(Boolean ordersIsPaid) {
		this.ordersIsPaid = ordersIsPaid;
	}

	public Date getOrderPlacedOn() {
		return orderPlacedOn;
	}

	public void setOrderPlacedOn(Date orderPlacedOn) {
		this.orderPlacedOn = orderPlacedOn;
	}

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Orders [orderedFoodID=" + orderedFoodID + ", ordersAmountDue=" + ordersAmountDue + ", ordersIsPaid="
				+ ordersIsPaid + ", orderPlacedOn=" + orderPlacedOn + ", orderID=" + orderID + ", customerID="
				+ customerID + "]";
	}
	
	
}
