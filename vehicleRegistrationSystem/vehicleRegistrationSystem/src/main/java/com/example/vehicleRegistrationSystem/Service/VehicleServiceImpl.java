package com.example.vehicleRegistrationSystem.Service;

import com.example.vehicleRegistrationSystem.Dao.VehicleDao;
import com.example.vehicleRegistrationSystem.Entity.NewUser;
import com.example.vehicleRegistrationSystem.Entity.Vehicle;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
public class VehicleServiceImpl implements VehicleService{

    private final VehicleDao vehicleDao;
    @Override
    public ResponseEntity listOfVehicles(Long id, Vehicle vehicle) {

    }

    @Override
    public void deleteVehicle(Long id, Vehicle vehicle) {

        Vehicle newVehicle=new Vehicle();
        Long vehicleId=vehicle.get
        vehicleDao.delete(vehicle.);
    }

    @Override
    public void save(Vehicle vehicle) {

    }

}
