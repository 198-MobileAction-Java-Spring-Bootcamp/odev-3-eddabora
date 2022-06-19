package com.example.vehicleRegistrationSystem.Controller;

import com.example.vehicleRegistrationSystem.Dto.UserDto;
import com.example.vehicleRegistrationSystem.Entity.NewUser;
import com.example.vehicleRegistrationSystem.Entity.Vehicle;
import com.example.vehicleRegistrationSystem.Service.UserService;
import com.example.vehicleRegistrationSystem.Service.VehicleService;
import com.example.vehicleRegistrationSystem.Validation.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Vehicle Registration System")
@RequiredArgsConstructor
public class VehicleController {

    private final UserService userService;
    private final UserValidator userValidator;

    private final VehicleService vehicleService;

    @PostMapping("/registration") //User Registration
    public String registration(@ModelAttribute("userForm") UserDto userDto, BindingResult bindingResult) {
        userValidator.validate(userDto, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);

        return "redirect:/welcome";
    }

    @GetMapping("/login") //User Login
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    @DeleteMapping("/{id}") //Delete User
    public ResponseEntity delete(@PathVariable Long id) {

        Vehicle vehicle= new Vehicle();
        userService.deleteUser(id);
        vehicleService.deleteVehicle(id,vehicle);

        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("/user/{id}") //Update Password
    public ResponseEntity updateNeighborhoodName(@PathVariable Long id,@RequestParam String oldPassword, @RequestParam String newPassword) {

        NewUser newUser= userService.updatePassword(id, oldPassword,newPassword);

        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/vehicles") //list of all vehicles of users
    public  ResponseEntity listOfVehicles(@PathVariable Long id, @RequestBody @Valid Vehicle vehicle) {
        return vehicleService.listOfVehicles(id,vehicle);

    }


    @PostMapping
    public ResponseEntity saveVehicle(@RequestBody Vehicle vehicle)
    {
        vehicleService.save(vehicle);
        return ResponseEntity.ok().build();

    }



}
