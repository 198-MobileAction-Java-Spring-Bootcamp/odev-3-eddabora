package com.example.vehicleRegistrationSystem.Convertor;

import com.example.vehicleRegistrationSystem.Dto.UserDto;
import com.example.vehicleRegistrationSystem.Entity.NewUser;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    NewUser convertToAddress(UserDto addressSaveRequestDto);

    UserDto convertToUser(NewUser newUser);
}