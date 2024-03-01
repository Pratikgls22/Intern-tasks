package org.example.spring_profiles.repositry;

import org.example.spring_profiles.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<User,Long> {
}
