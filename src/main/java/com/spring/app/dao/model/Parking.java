package com.spring.app.dao.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) // Все поля приватные
public class Parking {

    @Id
    UUID id;

    @Column(nullable = false)
    String name;

    // Заменить на DECIMAL
    @Column(nullable = false)
    double price;

    @Column(nullable = false)
    LocalDate startTime;

    @Column(nullable = false)
    LocalDate endTime;

    @Column(nullable = false, name = "setting_confirmation")
    boolean isSettingConfirmation;

    @Column(nullable = false, name = "setting_view")
    boolean isSettingView;

    @ManyToOne (targetEntity = Address.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    Address address;

    @Column(nullable = false)
    int parkingPlaces;

    @Column(name = "deleted")
    boolean isDeleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "parking_days",
            joinColumns =@JoinColumn(name = "parking_id"),
            inverseJoinColumns = @JoinColumn(name = "day_id"))
    Set <Day> days;

    public Parking(String name,
                   double price,
                   LocalDate startTime,
                   LocalDate endTime,
                   boolean isSettingConfirmation,
                   boolean isSettingView,
                   Address address,
                   int parkingPlaces,
                   boolean isDeleted,
                   Set<Day> days) {
        this.name = name;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isSettingConfirmation = isSettingConfirmation;
        this.isSettingView = isSettingView;
        this.address = address;
        this.parkingPlaces = parkingPlaces;
        this.isDeleted = isDeleted;
        this.days = days;
    }
}
