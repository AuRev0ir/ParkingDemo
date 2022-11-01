package com.spring.app.service;

import com.spring.app.dao.model.Address;
import com.spring.app.dao.model.City;

public interface CityService {

    City add (String name);
    City getInfo (long parkingId);

}
