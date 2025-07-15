package com.pedrodev.server_spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedrodev.server_spring.entities.Order;
import com.pedrodev.server_spring.entities.User;
import com.pedrodev.server_spring.entities.enums.OrderStatus;
import com.pedrodev.server_spring.repositories.OrderRepository;
import com.pedrodev.server_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Beatriz", "beatriz@email.com", "9111111", "123456");
		User u2 = new User(null, "Pedro", "pedro@email.com", "9000000", "123456");
		
		Order o1 = new Order(null, Instant.parse("2025-07-14T18:24:53Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-14T18:22:53Z"), OrderStatus.CANCELED, u1);
		Order o3 = new Order(null, Instant.parse("2025-07-14T18:23:53Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}
