package org.ass.orderservice.controller;

import org.ass.orderservice.dto.OrderDto;
import org.ass.orderservice.entity.OrderEntity;
import org.ass.orderservice.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	
	@Autowired
	private OrderServiceImpl orderServiceImpl;
	
	@PostMapping(value="/processOrder")
	public @ResponseBody String processOrder(@RequestBody OrderDto dto ) {
		return orderServiceImpl.processOrder(dto);
		
	}

}
