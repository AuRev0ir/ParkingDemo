package com.spring.app.dao.model;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "addresses")
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // Все поля приватные
public class Address {

    @Id
    UUID id;

    @ManyToOne(targetEntity = City.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    City city;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    int houseNumber;

    public Address(City city, String name, int houseNumber) {
        this.city = city;
        this.name = name;
        this.houseNumber = houseNumber;
    }
}
