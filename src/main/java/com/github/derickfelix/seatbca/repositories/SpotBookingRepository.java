package com.github.derickfelix.seatbca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.derickfelix.seatbca.models.SpotBooking;

public interface SpotBookingRepository extends JpaRepository<SpotBooking, Long> {
}
