package com.spring.app.rest.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParkingDto {


    UUID id;

    String name;

    double price;

    LocalDate startTime;

    LocalDate endTime;

    boolean isSettingConfirmation;

    boolean isSettingView;

    AddressDto address;

    int parkingPlaces;

    boolean isDeleted;

    Set<DayDto> days;

}
