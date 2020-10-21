package nl.rockstars.rockstarsdemoapp.repository;

import nl.rockstars.rockstarsdemoapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    List<User> findAllByLastName(String lastName);
}
