package org.ass.orderservice.repository.impl;

import org.ass.orderservice.entity.OrderEntity;
import org.ass.orderservice.repository.OrderRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public OrderEntity saveOrder(OrderEntity orderEntity) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.merge(orderEntity);
		transaction.commit();
		return orderEntity;
	}

}
