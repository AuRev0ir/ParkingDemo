package com.spring.app.rest.mapper;

import com.spring.app.dao.model.City;
import com.spring.app.dao.model.Day;
import com.spring.app.dao.model.Parking;
import com.spring.app.rest.dto.CityDto;
import com.spring.app.rest.dto.DayDto;
import com.spring.app.rest.dto.ParkingDto;

import java.util.List;
import java.util.Set;

public interface DayMapper {

    DayDto toDto (Day day);

    Set<DayDto> toDto (Set<Parking> parking);
    Day toEntity (DayDto dayDto);

    Set<Day> toEntity (Set<DayDto> parking);

}
