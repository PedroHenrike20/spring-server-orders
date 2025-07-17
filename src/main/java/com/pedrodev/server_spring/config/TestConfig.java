package com.pedrodev.server_spring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedrodev.server_spring.entities.Category;
import com.pedrodev.server_spring.entities.Order;
import com.pedrodev.server_spring.entities.OrderItem;
import com.pedrodev.server_spring.entities.Payment;
import com.pedrodev.server_spring.entities.Product;
import com.pedrodev.server_spring.entities.User;
import com.pedrodev.server_spring.entities.enums.OrderStatus;
import com.pedrodev.server_spring.repositories.CategoryRepository;
import com.pedrodev.server_spring.repositories.OrderItemRepository;
import com.pedrodev.server_spring.repositories.OrderRepository;
import com.pedrodev.server_spring.repositories.ProductRepository;
import com.pedrodev.server_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Smartphones");
		Category cat4 = new Category(null, "Computers");
		
		
		Product p1 = new Product(null, "Código Limpo", "Lorem Ipsum dolor sit amet", 120.0, "");
		Product p2 = new Product(null, "Macbook Pro", "Lorem Ipsum dolor sit amet", 12500.0, "");
		Product p3 = new Product(null, "PC Gamer Intel 14 ger.", "Lorem Ipsum dolor sit amet", 9000.0, "");
		Product p4 = new Product(null, "Iphone 15 Pro Max", "Lorem Ipsum dolor sit amet", 6900.0, "");
		Product p5 = new Product(null, "Smart TV 80'' Samsung Crystal", "Lorem Ipsum dolor sit amet", 7200.0, "");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p3.getCategories().add(cat4);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat1);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		
		
		
		User u1 = new User(null, "Beatriz", "beatriz@email.com", "9111111", "123456");
		User u2 = new User(null, "Pedro", "pedro@email.com", "9000000", "123456");
		
		Order o1 = new Order(null, Instant.parse("2025-07-14T18:24:53Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-07-14T18:22:53Z"), OrderStatus.CANCELED, u1);
		Order o3 = new Order(null, Instant.parse("2025-07-14T18:23:53Z"), OrderStatus.WAITING_PAYMENT, u2);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2025-07-14T20:24:53Z"), o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
		
		
	}
}
