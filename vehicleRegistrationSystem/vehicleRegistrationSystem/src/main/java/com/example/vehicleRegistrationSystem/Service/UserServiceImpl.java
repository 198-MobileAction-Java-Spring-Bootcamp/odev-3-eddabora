package com.example.vehicleRegistrationSystem.Service;

import com.example.vehicleRegistrationSystem.Dao.UserDao;
import com.example.vehicleRegistrationSystem.Dto.UserDto;
import com.example.vehicleRegistrationSystem.Entity.NewUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserDao userDao;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public NewUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void save(UserDto userDto) { //User Registration
        NewUser user=new NewUser();
        user.setUserPassword((bCryptPasswordEncoder.encode(userDto.getUserPassword())));
        userDao.save(user);
        log.info("User registration is successful.");
    }

    @Override
    public void deleteUser(Long id) {

         NewUser newUser = getById(id);

         userDao.delete(newUser);

    }

    @Override
    public NewUser updatePassword(Long id, String oldPassword, String newPassword) {
        Optional<NewUser> neighborhoodOptional = UserDao.findById(id);

        NewUser newUser;
        if (neighborhoodOptional.isPresent()) {
            newUser = neighborhoodOptional.get();
        } else {
            throw new NotFoundException("User not found" );
        }

        newUser.setUserPassword(newPassword);

        return userDao.save(newUser);

    }


    private NewUser getById(Long id) {

        Optional<NewUser> addressOptional = userDao.findById(id);

        NewUser newUser;
        if (addressOptional.isPresent()) {
            newUser = addressOptional.get();
        } else {
            throw new RuntimeException("User not found");
        }
        return newUser;
    }



}
