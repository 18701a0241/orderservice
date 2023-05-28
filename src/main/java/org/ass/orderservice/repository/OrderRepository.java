package org.ass.orderservice.repository;

import org.ass.orderservice.entity.OrderEntity;

public interface OrderRepository {
	
	public OrderEntity saveOrder(OrderEntity orderEntity);

}
