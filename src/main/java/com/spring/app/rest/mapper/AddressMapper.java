package com.spring.app.rest.mapper;


import com.spring.app.dao.model.Address;
import com.spring.app.dao.model.City;
import com.spring.app.dao.model.Parking;
import com.spring.app.rest.dto.AddressDto;
import com.spring.app.rest.dto.CityDto;
import com.spring.app.rest.dto.ParkingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {

    AddressDto toDto (Address address);

    List<AddressDto> toDto (List<Address> parking);

    Address toEntity(AddressDto addressDto);

    List<Address> toEntity (List<AddressDto> parking);

}
