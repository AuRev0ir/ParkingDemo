package com.spring.app.rest.dto;

import com.spring.app.dao.model.DaysEnum;
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
public class DayDto {

    UUID id;

    DaysEnum name;

}
