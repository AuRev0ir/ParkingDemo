package com.spring.app.rest.controller;

import com.spring.app.rest.dto.AddressDto;
import com.spring.app.service.AddressService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/maps")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AddressController {

    AddressService addressService;


    @GetMapping("address/{parking_id}")
    public AddressDto getInfo (@PathVariable("parking_id") UUID id){
        return addressService.getInfo(id);
    }


    @PostMapping ("/address")
    public AddressDto add (AddressDto dto){
        return addressService.add(dto);
    }

}
