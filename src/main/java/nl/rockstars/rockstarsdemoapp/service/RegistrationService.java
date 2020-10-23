package nl.rockstars.rockstarsdemoapp.service;

import nl.rockstars.rockstarsdemoapp.dto.RegistrationDto;
import nl.rockstars.rockstarsdemoapp.entity.User;

import java.util.List;

public interface RegistrationService {
    User create(User user);
    User update(User userEntity, User user);
    Boolean deleteById(Long id);
    User findByEmail(String email);
    List<User> findAll();
    User findById(Long id);
    List<User> findAllByLastName(String lastName);
    User initializeUserAndBindDtoData(RegistrationDto registrationDto);
}
