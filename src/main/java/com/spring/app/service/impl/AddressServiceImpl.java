package com.spring.app.service.impl;

import com.spring.app.dao.model.Address;
import com.spring.app.dao.repository.AddressRepository;
import com.spring.app.dao.repository.CityRepository;
import com.spring.app.dao.repository.ParkingRepository;
import com.spring.app.rest.dto.AddressDto;
import com.spring.app.rest.mapper.AddressMapper;
import com.spring.app.rest.mapper.CityMapper;
import com.spring.app.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressServiceImpl implements AddressService {

    ParkingRepository parkingRepository;
    CityRepository cityRepository;
    AddressMapper addressMapper;
    CityMapper cityMapper;
    AddressRepository addressRepository;

    @Override
    public AddressDto add (AddressDto dto) {

        var cityFromDB = cityRepository
                .findByName(dto.getCity().getName())
                .orElseThrow(() -> new RuntimeException("City not found in database"));

        return addressMapper.toDto(addressRepository.save(new Address(
                cityMapper.toEntity(dto.getCity()),dto.getName(),dto.getHouseNumber())));
    }

    @Override
    public AddressDto getInfo(UUID parkingId) {

        var parkingFromDB = parkingRepository
                .findById(parkingId)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));

        return addressMapper.toDto(addressRepository
                .findById(parkingFromDB.getAddress().getId())
                .orElseThrow(() -> new RuntimeException("Address not found in database")));
    }
}
