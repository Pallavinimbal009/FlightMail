package com.example.flightmail.repository;

import com.example.flightmail.entity.FlightMail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightMailRepository  extends JpaRepository<FlightMail, Long> {
}
