package com.github.derickfelix.seatbca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.derickfelix.seatbca.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
