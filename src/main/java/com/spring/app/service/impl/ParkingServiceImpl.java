package com.spring.app.service.impl;

import com.spring.app.dao.model.Parking;
import com.spring.app.dao.repository.ParkingRepository;
import com.spring.app.service.ParkingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ParkingServiceImpl implements ParkingService {


    ParkingRepository parkingRepository;


    @Override
    public List<Parking> getAll() {
        return parkingRepository.findAll();
    }

    @Override
    public Parking getInfo(long id) {
        return parkingRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));
    }


    // нужно dto
    @Override
    public Long add() {
        return null;
    }

    // нужно dto
    @Override
    public Long update() {
        return null;
    }

    @Override
    public void remove(long id) {
        var parkingFromDB = parkingRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));
        parkingRepository.delete(parkingFromDB);
    }
}
