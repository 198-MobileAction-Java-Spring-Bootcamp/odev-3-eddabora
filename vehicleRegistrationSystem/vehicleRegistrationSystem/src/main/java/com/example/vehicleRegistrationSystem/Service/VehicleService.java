package com.example.vehicleRegistrationSystem.Service;

import com.example.vehicleRegistrationSystem.Entity.Vehicle;
import org.springframework.http.ResponseEntity;

public interface VehicleService {
    ResponseEntity listOfVehicles(Long id, Vehicle vehicle);

    void deleteVehicle(Long id, Vehicle vehicle);

    void save(Vehicle vehicle);
}
