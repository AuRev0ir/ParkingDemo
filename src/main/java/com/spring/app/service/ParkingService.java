package com.spring.app.service;

import com.spring.app.dao.model.Parking;
import com.spring.app.rest.dto.ParkingDto;

import java.util.List;
import java.util.UUID;

public interface ParkingService {

    List<ParkingDto> getAll();
    ParkingDto getInfo(UUID id);
    UUID create (ParkingDto dto);
    ParkingDto update (ParkingDto dto);
    boolean delete (UUID id);

}
