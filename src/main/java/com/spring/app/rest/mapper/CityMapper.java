package com.spring.app.rest.mapper;


import com.spring.app.dao.model.City;
import com.spring.app.rest.dto.CityDto;
import org.mapstruct.Mapper;


@Mapper
public interface CityMapper {

    CityDto toDto (City city);

    City toEntity(CityDto cityDto);

}
