package com.pedrodev.server_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrodev.server_spring.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
