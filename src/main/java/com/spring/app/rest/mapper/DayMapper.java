package com.spring.app.rest.mapper;

import com.spring.app.dao.model.Day;
import com.spring.app.rest.dto.DayDto;
import org.mapstruct.Mapper;

import java.util.Set;

@Mapper
public interface DayMapper {

    DayDto toDto (Day day);

    Set<DayDto> toDto (Set<Day> days);
    Day toEntity (DayDto dayDto);

    Set<Day> toEntity (Set<DayDto> parking);

}
