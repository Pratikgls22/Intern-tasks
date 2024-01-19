package org.example.springbootvalidator.repositry;

import org.example.springbootvalidator.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
