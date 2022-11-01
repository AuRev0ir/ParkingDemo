package com.spring.app.service.impl;

import com.spring.app.dao.model.City;
import com.spring.app.dao.repository.CityRepository;
import com.spring.app.dao.repository.ParkingRepository;
import com.spring.app.service.CityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityServiceImpl implements CityService {

    ParkingRepository parkingRepository;
    CityRepository cityRepository;

    @Override
    public City add(String name) {
        return cityRepository.save(new City(name));
    }

    @Override
    public City getInfo(long parkingId) {

        var parkingFromDB = parkingRepository
                .findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));

        return cityRepository
                .findById(parkingFromDB.getAddress().getCity().getId())
                .orElseThrow(() -> new RuntimeException("City not found in database"));
    }
}
