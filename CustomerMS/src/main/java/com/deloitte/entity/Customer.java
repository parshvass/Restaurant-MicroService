package com.deloitte.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerID;
	private String customerName;
	private String customerEmail;
	private Long customerPhoneNO;
	private Integer restaurantID;
	private Boolean customerHasDues;

	public Customer() {
		super();
	}

	public Customer(Integer customerID, String customerName, String customerEmail, Long customerPhoneNO,
			Integer restaurantID, Boolean customerHasDues) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPhoneNO = customerPhoneNO;
		this.restaurantID = restaurantID;
		this.customerHasDues = customerHasDues;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Long getCustomerPhoneNO() {
		return customerPhoneNO;
	}

	public void setCustomerPhoneNO(Long customerPhoneNO) {
		this.customerPhoneNO = customerPhoneNO;
	}

	public Integer getRestaurantID() {
		return restaurantID;
	}

	public void setRestaurantID(Integer restaurantID) {
		this.restaurantID = restaurantID;
	}

	public Boolean getCustomerHasDues() {
		return customerHasDues;
	}

	public void setCustomerHasDues(Boolean customerHasDues) {
		this.customerHasDues = customerHasDues;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPhoneNO=" + customerPhoneNO + ", restaurantID=" + restaurantID
				+ ", customerHasDues=" + customerHasDues + "]";
	}

}
