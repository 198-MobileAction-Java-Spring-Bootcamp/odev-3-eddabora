package com.example.vehicleRegistrationSystem.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @Column(name = "plate", nullable = false)
    private  String plate;

    @Id
    @Column(name = "model", nullable = false)
    private  String model;

    @Id
    @Column(name = "brand", nullable = false)
    private  String brand;

    @ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="user_id",nullable = false)
    private NewUser newUser;
}
