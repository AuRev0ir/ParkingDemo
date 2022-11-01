package com.spring.app.service;

import com.spring.app.dao.model.Address;
import com.spring.app.rest.dto.AddressDto;

import java.util.UUID;

public interface AddressService {

    AddressDto add (AddressDto dto);
    AddressDto getInfo (UUID parkingId);

}
