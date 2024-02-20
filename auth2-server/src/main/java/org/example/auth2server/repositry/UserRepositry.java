package org.example.auth2server.repositry;

import org.example.auth2server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositry extends JpaRepository<Users,Integer> {
    Optional<Users> findByName(String username);
}
