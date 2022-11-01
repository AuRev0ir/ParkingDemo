package com.spring.app.service.impl;

import com.spring.app.dao.model.City;
import com.spring.app.dao.repository.CityRepository;
import com.spring.app.dao.repository.ParkingRepository;
import com.spring.app.rest.dto.CityDto;
import com.spring.app.rest.mapper.CityMapper;
import com.spring.app.service.CityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CityServiceImpl implements CityService {

    ParkingRepository parkingRepository;
    CityRepository cityRepository;
    CityMapper cityMapper;

    @Override
    public CityDto add(String name) {
        return cityMapper.toDto(cityRepository.save(new City(name)));
    }

    @Override
    public CityDto getInfo(UUID parkingId) {

        var parkingFromDB = parkingRepository
                .findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));

        return cityMapper.toDto(cityRepository
                .findById(parkingFromDB.getAddress().getCity().getId())
                .orElseThrow(() -> new RuntimeException("City not found in database")));
    }
}
