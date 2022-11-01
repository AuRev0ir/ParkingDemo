package com.spring.app.rest.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AddressDto {

    UUID id;

    CityDto city;

    String name;

    int houseNumber;

}
