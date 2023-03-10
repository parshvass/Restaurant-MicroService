package com.deloitte.service;

import java.util.List;

import com.deloitte.entity.Food;

public interface IFoodService {
	public List<Food> fetchMenu();

	public List<Food> fetchJainMenu();

	public List<Food> fetchFoodUnderX(Double foodPrice);

	public Food fetchFoodByID(Integer foodID);

	public List<Food> fetchFoodByOrdersID(Integer ordersID);

}
