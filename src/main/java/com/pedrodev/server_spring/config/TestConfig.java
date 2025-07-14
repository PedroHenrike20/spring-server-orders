package com.pedrodev.server_spring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedrodev.server_spring.entities.User;
import com.pedrodev.server_spring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Beatriz", "beatriz@email.com", "9111111", "123456");
		User u2 = new User(null, "Pedro", "pedro@email.com", "9000000", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
