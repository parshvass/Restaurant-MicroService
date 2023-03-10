package com.deloitte;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.model.Orders;
import com.deloitte.model.Response;

@FeignClient(name = "order-ms")
public interface IOrdersRest {
	
	@GetMapping("/fetchByCustomersID/{customersID}")
	public List<Orders> fetchByCustomersID(@PathVariable Integer customersID);

	@GetMapping("fetchCustomersWithDues")
	public ResponseEntity<Response> fetchCustomersWithDues();
}
