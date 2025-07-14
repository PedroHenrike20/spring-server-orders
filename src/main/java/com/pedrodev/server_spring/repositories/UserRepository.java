package com.pedrodev.server_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pedrodev.server_spring.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
