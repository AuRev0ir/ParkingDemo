package com.spring.app.service;

import com.spring.app.dao.model.Address;
import com.spring.app.dao.model.City;
import com.spring.app.rest.dto.CityDto;

import java.util.UUID;

public interface CityService {

    boolean addCity (CityDto name);
    CityDto getInfo (UUID parkingId);

}
