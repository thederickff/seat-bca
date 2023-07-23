package com.github.derickfelix.seatbca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.derickfelix.seatbca.models.Spot;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
