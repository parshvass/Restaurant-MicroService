package com.deloitte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.entity.Food;
import com.deloitte.repo.IFoodRepo;

@Service
public class FoodServiceImpl implements IFoodService {

	@Autowired
	private IFoodRepo foodRepo;

	@Override
	public List<Food> fetchMenu() {
		return foodRepo.findAll();
	}

	@Override
	public List<Food> fetchJainMenu() {
		return foodRepo.findByFoodIsJain(true);
	}

	@Override
	public List<Food> fetchFoodUnderX(Double foodPrice) {
		return foodRepo.findByFoodPriceLessThanEqual(foodPrice);
	}

	@Override
	public Food fetchFoodByID(Integer foodID) {
		return foodRepo.findById(foodID).get();
	}

	@Override
	public List<Food> fetchFoodByOrdersID(Integer ordersID) {
		// TODO Auto-generated method stub
		return foodRepo.findByOrdersID(ordersID);
	}

}
