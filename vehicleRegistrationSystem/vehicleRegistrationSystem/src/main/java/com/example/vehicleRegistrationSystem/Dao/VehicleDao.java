package com.example.vehicleRegistrationSystem.Dao;


import org.apache.tomcat.jni.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public interface VehicleDao extends JpaRepository<User, Long> {
}
