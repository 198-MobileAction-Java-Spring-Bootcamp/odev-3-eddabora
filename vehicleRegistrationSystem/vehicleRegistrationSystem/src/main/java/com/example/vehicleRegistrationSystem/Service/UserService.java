package com.example.vehicleRegistrationSystem.Service;

import com.example.vehicleRegistrationSystem.Dto.UserDto;
import com.example.vehicleRegistrationSystem.Entity.NewUser;

public interface UserService {

    NewUser findByUsername(String username);

    void save(UserDto userDto);

    void deleteUser(Long id);

    NewUser updatePassword(Long id, String oldPassword, String newPassword);
}
