package nl.rockstars.rockstarsdemoapp.controller;

import nl.rockstars.rockstarsdemoapp.dto.RegistrationDto;
import nl.rockstars.rockstarsdemoapp.entity.User;
import nl.rockstars.rockstarsdemoapp.service.RegistrationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    // Get all users.
    @GetMapping("/users")
    List<User> allUsers() {
        return registrationService.findAll();
    }

    // Create new user.
    @PostMapping("/users")
    User newUser(@RequestBody RegistrationDto registrationDto) {
        User user = registrationService.initializeUserAndBindDtoData(registrationDto);
        return registrationService.create(user);
    }

    // Find a user by id.
    @GetMapping("/users/{id}")
    User getUser(@PathVariable Long id) {
        return registrationService.findById(id);
    }

    // Update a user by id. If no User is found by id from db, a new user is created and returned.
    @PutMapping("/users/{id}")
    User updateUser(@PathVariable Long id, @RequestBody RegistrationDto registrationDto) {
        User userEntity = registrationService.findById(id);
        User user = registrationService.initializeUserAndBindDtoData(registrationDto);
        if(userEntity == null) {
            return registrationService.create(user);
        }
        return registrationService.update(userEntity, user);
    }

    // Delete user by id
    @DeleteMapping("/users/{id}")
    Boolean deleteUser(@PathVariable Long id) {
        return registrationService.deleteById(id);
    }
}
