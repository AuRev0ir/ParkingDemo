package com.spring.app.dao.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cities")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // Все поля приватные
public class City {

    @Id
    UUID id;

    @Column(nullable = false)
    String name;

    public City(String name) {
        this.name = name;
    }
}
