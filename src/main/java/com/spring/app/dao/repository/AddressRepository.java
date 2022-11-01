package com.spring.app.dao.repository;

import com.spring.app.dao.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {

    Optional<Address> findByName(String name);

    boolean existsByName(String addressName);
}
