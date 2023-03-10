package com.deloitte.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.entity.Food;
import com.deloitte.service.FoodServiceImpl;

@RestController
@RequestMapping("/food")
public class FoodController {
	@Autowired
	private FoodServiceImpl foodService;
	
	@GetMapping("/fetchMenu")
	public List<Food> fetchMenu() {
		return foodService.fetchMenu();
	}

	@GetMapping("/fetchJainMenu")
	public List<Food> fetchJainMenu() {
		return foodService.fetchJainMenu();
	}

	@GetMapping("/fetchFoodUnderX/{foodPrice}")
	public List<Food> fetchFoodUnderX(@PathVariable Double foodPrice) {
		return foodService.fetchFoodUnderX(foodPrice);
	}

	@GetMapping("/fetchFoodByID/{foodID}")
	public Food fetchFoodByID(@PathVariable Integer foodID) {
		return foodService.fetchFoodByID(foodID);
	}
	
	@GetMapping("/fetchFoodByOrdersID/{ordersID}")
	public List<Food> fetchFoodByOrdersID(@PathVariable Integer ordersID){
		return foodService.fetchFoodByOrdersID(ordersID);
	}
	
//	@GetMapping("/fetchFoodByOrdersID/{ordersID}")
//	public Food[] fetchFoodByOrdersID(@PathVariable Integer ordersID){
//		return (Food[]) foodService.fetchFoodByOrdersID(ordersID).toArray();
//	}
	
	@GetMapping("/fetchOrdersPrepTime/{ordersID}")
	public Integer fetchOrdersPrepTime(@PathVariable Integer ordersID){
		List<Food> orderedFood = foodService.fetchFoodByOrdersID(ordersID);
		Integer sum = orderedFood.stream().mapToInt(x->x.getFoodPrepTime()).sum();
		return sum;
	}
}
