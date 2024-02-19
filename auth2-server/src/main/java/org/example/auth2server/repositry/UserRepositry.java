package org.example.auth2server.repositry;

import org.example.auth2server.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositry extends JpaRepository<Users,Integer> {
    void findByName(String username);
}
