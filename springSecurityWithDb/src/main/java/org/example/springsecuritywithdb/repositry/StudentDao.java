package org.example.springsecuritywithdb.repositry;

import lombok.RequiredArgsConstructor;
import org.example.springsecuritywithdb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentDao extends JpaRepository<Student, String>{
    public Student findByName(String name);
}
