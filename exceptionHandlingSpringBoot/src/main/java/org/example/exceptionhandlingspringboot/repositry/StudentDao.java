package org.example.exceptionhandlingspringboot.repositry;

import org.example.exceptionhandlingspringboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {
}
