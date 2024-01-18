package org.example.springboot_crud_jpa.repo;

import org.example.springboot_crud_jpa.entity.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDao extends JpaRepository<Emp,Long> {
}
