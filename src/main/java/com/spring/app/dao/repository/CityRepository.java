package com.spring.app.dao.repository;

import com.spring.app.dao.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CityRepository extends JpaRepository<City, UUID> {

    Optional<City> findByName(String name);

    boolean existsByName(String CityName);

}
