package com.spring.app.service.impl;

import com.spring.app.dao.model.Parking;
import com.spring.app.dao.repository.AddressRepository;
import com.spring.app.dao.repository.ParkingRepository;
import com.spring.app.rest.dto.ParkingDto;
import com.spring.app.rest.mapper.DayMapper;
import com.spring.app.rest.mapper.ParkingMapper;
import com.spring.app.service.ParkingService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ParkingServiceImpl implements ParkingService {

    AddressRepository addressRepository;
    ParkingRepository parkingRepository;
    ParkingMapper parkingMapper;
    DayMapper dayMapper;

    @Override
    public List<ParkingDto> getAll() {
        return parkingMapper.toDto(parkingRepository.findAll());
    }

    @Override
    public ParkingDto getInfo(UUID id) {
        return parkingMapper
                .toDto(parkingRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Parking not found in database")));
    }

    @Override
    public UUID create (ParkingDto dto) {

        return parkingRepository.save(new Parking(
                dto.getName(),
                dto.getPrice(),
                dto.getStartTime(),
                dto.getEndTime(),
                dto.isSettingConfirmation(),
                dto.isSettingView(),
                addressRepository.findById(dto.getAddress().getId())
                        .orElseThrow(() -> new RuntimeException("Address not found in database")),
                dto.getParkingPlaces(),
                dto.isDeleted(),
                dayMapper.toEntity(dto.getDays()))
        ).getId();
    }

    @Override
    public ParkingDto update (ParkingDto dto) {

        var parkingFromDB  = parkingRepository
                .findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Employee not found in database"));

        parkingMapper.updateFromDto(dto, parkingFromDB);
        return parkingMapper.toDto(parkingRepository.save(parkingFromDB));
    }

    //Уточнить, что возвращает метод!
    @Override
    public boolean delete (UUID id) {
        var parkingFromDB = parkingRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Parking not found in database"));
        parkingRepository.delete(parkingFromDB);
        return true;
    }
}
