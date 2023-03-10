package com.deloitte.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Food {
	private String foodName;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer foodID;
	private Double foodPrice;
	private Boolean foodIsJain;
	private Integer foodPrepTime;
	private Integer ordersID;

	public Food() {
		super();
	}

	public Food(String foodName, Integer foodID, Double foodPrice, Boolean foodIsJain, Integer foodPrepTime,
			Integer ordersID) {
		super();
		this.foodName = foodName;
		this.foodID = foodID;
		this.foodPrice = foodPrice;
		this.foodIsJain = foodIsJain;
		this.foodPrepTime = foodPrepTime;
		this.ordersID = ordersID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Integer getFoodID() {
		return foodID;
	}

	public void setFoodID(Integer foodID) {
		this.foodID = foodID;
	}

	public Double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(Double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public Boolean getFoodIsJain() {
		return foodIsJain;
	}

	public void setFoodIsJain(Boolean foodIsJain) {
		this.foodIsJain = foodIsJain;
	}

	public Integer getFoodPrepTime() {
		return foodPrepTime;
	}

	public void setFoodPrepTime(Integer foodPrepTime) {
		this.foodPrepTime = foodPrepTime;
	}

	public Integer getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
	}

	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodID=" + foodID + ", foodPrice=" + foodPrice + ", foodIsJain="
				+ foodIsJain + ", foodPrepTime=" + foodPrepTime + ", ordersID=" + ordersID + "]";
	}

}
