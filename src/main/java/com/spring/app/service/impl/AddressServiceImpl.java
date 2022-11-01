package com.spring.app.service.impl;

import com.spring.app.dao.model.Address;
import com.spring.app.dao.repository.AddressRepository;
import com.spring.app.dao.repository.CityRepository;
import com.spring.app.dao.repository.ParkingRepository;
import com.spring.app.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressServiceImpl implements AddressService {

    ParkingRepository parkingRepository;

    CityRepository cityRepository;
    AddressRepository addressRepository;


    // нужно dto
    @Override
    public Address add(String cityName, String name, int houseNumber) {
        var cityFromDB = cityRepository
                .findByName(cityName)
                .orElseThrow(() -> new RuntimeException("City not found in database"));

        return addressRepository.save(new Address(cityFromDB, name, houseNumber));
    }

    @Override
    public Address getInfo(long parkingId) {

        var parkingFromDB = parkingRepository
                .findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));

        return addressRepository
                .findById(parkingFromDB.getAddress().getId())
                .orElseThrow(() -> new RuntimeException("Address not found in database"));
    }
}
