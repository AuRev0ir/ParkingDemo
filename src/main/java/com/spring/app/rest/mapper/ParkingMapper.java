package com.spring.app.rest.mapper;


import com.spring.app.dao.model.Parking;
import com.spring.app.rest.dto.CityDto;
import com.spring.app.rest.dto.ParkingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface ParkingMapper {

    ParkingDto toDto (Parking parking);

    List<ParkingDto> toDto (List<Parking> parking);

    Parking toEntity (ParkingDto parkingDto);

    List<Parking> toEntity (List<ParkingDto> parkingDto);

    void updateFromDto(ParkingDto parkingFillFormDto, @MappingTarget Parking parking);

}
