package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Tracking;
import com.example.demo.domain.Users;

public interface TrackingRepository extends JpaRepository<Tracking, Integer> {
	


}
