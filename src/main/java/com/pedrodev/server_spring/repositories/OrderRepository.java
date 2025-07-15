package com.pedrodev.server_spring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrodev.server_spring.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {

}
