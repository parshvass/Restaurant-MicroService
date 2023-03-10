package com.deloitte.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.entity.Food;

@Repository
public interface IFoodRepo extends JpaRepository<Food, Integer> {
	public List<Food> findByFoodIsJain(Boolean foodIsJain);

	public List<Food> findByFoodPriceLessThanEqual(Double foodPrice);
	
	public List<Food> findByOrdersID(Integer ordersID);
}
