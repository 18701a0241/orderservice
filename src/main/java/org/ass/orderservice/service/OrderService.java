package org.ass.orderservice.service;

import org.ass.orderservice.dto.OrderDto;
import org.ass.orderservice.entity.OrderEntity;

public interface OrderService {
	
	public String processOrder(OrderDto orderDto);

}
