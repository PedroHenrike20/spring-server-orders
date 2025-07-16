package com.pedrodev.server_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrodev.server_spring.entities.OrderItem;
import com.pedrodev.server_spring.entities.pk.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk>{
	
}
