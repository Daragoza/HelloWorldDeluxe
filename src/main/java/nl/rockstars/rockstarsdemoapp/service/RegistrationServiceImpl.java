package nl.rockstars.rockstarsdemoapp.service;

import nl.rockstars.rockstarsdemoapp.dto.RegistrationDto;
import nl.rockstars.rockstarsdemoapp.entity.User;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {
    @Override
    public User create(RegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getPassword()
        );
        return user;
    }

    @Override
    public User update(RegistrationDto registrationDto) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        return null;
    }
}
