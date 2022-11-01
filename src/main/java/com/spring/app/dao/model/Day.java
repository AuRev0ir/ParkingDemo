package com.spring.app.dao.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "days")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // Все поля приватные
public class Day {

    @Id
    UUID id;

    @Enumerated(EnumType.STRING)
    DaysEnum name;

    public Day(DaysEnum name) {
        this.name = name;
    }
}
