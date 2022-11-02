package com.spring.app.dao.repository;

import com.spring.app.dao.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ParkingRepository extends JpaRepository <Parking, UUID> {

}
