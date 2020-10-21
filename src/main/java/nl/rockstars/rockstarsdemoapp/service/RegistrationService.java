package nl.rockstars.rockstarsdemoapp.service;

import nl.rockstars.rockstarsdemoapp.dto.RegistrationDto;
import nl.rockstars.rockstarsdemoapp.entity.User;

import java.util.List;

public interface RegistrationService {
    User create(RegistrationDto registrationDto);
    User update(RegistrationDto registrationDto);
    Boolean deleteById(Long id);
    User findByEmail(String email);
    User findById(Long id);
    List<User> findAllByLastName(String lastName);
}
