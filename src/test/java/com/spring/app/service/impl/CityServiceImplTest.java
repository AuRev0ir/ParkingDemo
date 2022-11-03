package com.spring.app.service.impl;

import com.spring.app.dao.model.City;
import com.spring.app.dao.repository.CityRepository;
import com.spring.app.rest.dto.CityDto;
import com.spring.app.rest.mapper.CityMapper;
import com.spring.app.service.CityService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@FieldDefaults(level = AccessLevel.PRIVATE)
class CityServiceImplTest {

    public static final City CITY = new City("BELGOROD");
    @Autowired
    CityMapper cityMapper;
    @MockBean
    CityRepository cityRepository;
    @Autowired
    CityService cityService;

    @Test
    void addCity() {

        CityDto cityFillFormDto = cityMapper.toDto(CITY);
        boolean isCityAdded = cityService.addCity(cityFillFormDto);
        Assertions.assertTrue(isCityAdded);
    }

    @Test
    void addCityFailTest() {

        CityDto cityFillFormDto = cityMapper.toDto(new City(null));
        boolean isCityAdded = cityService.addCity(cityFillFormDto);
        Assertions.assertFalse(isCityAdded);
    }

//    @Test
//    void getInfo() {
//
//        CityDto cityFillFormDto = cityMapper.toDto(CITY);
//        Assertions.assertNull(cityService.getInfo(CITY.getId()));
//        Assertions.assertSame(cityFillFormDto, cityService.getInfo(CITY.getId()));
//    }
}