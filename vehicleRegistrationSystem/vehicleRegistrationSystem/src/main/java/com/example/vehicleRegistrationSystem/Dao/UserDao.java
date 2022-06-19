package com.example.vehicleRegistrationSystem.Dao;

import com.example.vehicleRegistrationSystem.Entity.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
@Repository
public interface UserDao extends JpaRepository<NewUser, Long> {

    NewUser findByUsername(String username);




}
