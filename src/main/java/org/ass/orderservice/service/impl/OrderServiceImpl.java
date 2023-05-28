package org.ass.orderservice.service.impl;

import java.util.Date;


import org.ass.orderservice.dto.OrderDto;
import org.ass.orderservice.entity.OrderEntity;
import org.ass.orderservice.repository.impl.OrderRepositoryImpl;
import org.ass.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderRepositoryImpl orderRepositoryImpl;
	
	 
	@Autowired
	private RestTemplate restTemplate;



	@Override
	public String processOrder(OrderDto orderDto) {
		OrderEntity orderEntity=new OrderEntity();
		orderEntity.setProductId(orderDto.getProductId());
		orderEntity.setPaymentMode(orderDto.getPaymentMode());
		orderEntity.setQuantity(orderDto.getQuantity());
		orderEntity.setSoldDate(new Date());
	
		StringBuilder urlbuilder = new StringBuilder();
		urlbuilder.append("http://localhost:8080/productservice/findProductPriceByProductById/");
		urlbuilder.append(orderDto.getProductId());
		
		
		Double ProductPrice=restTemplate.getForObject(urlbuilder.toString(), Double.class);
		System.out.println("ProductPrice:"+ProductPrice);
		orderEntity.setTotalPrice(ProductPrice * orderDto.getQuantity());
		orderRepositoryImpl.saveOrder(orderEntity);
		return "Order Placed Successfully";
		
	}

	
	}


