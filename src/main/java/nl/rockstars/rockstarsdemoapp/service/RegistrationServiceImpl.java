package nl.rockstars.rockstarsdemoapp.service;

import nl.rockstars.rockstarsdemoapp.dto.RegistrationDto;
import nl.rockstars.rockstarsdemoapp.entity.User;
import nl.rockstars.rockstarsdemoapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private UserRepository userRepository;

    public RegistrationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(RegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                registrationDto.getPassword()
        );
        return userRepository.save(user);
    }

    @Override
    public User update(RegistrationDto registrationDto) {
        User user = userRepository.findById(registrationDto.getId()).orElse(null);
        //TODO: Add null check...
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        return userRepository.save(user);
    }

    @Override
    public Boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        //TODO: Can return null so either create new User or give proper warning.
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        return userRepository.findAllByLastName(lastName);
    }
}
