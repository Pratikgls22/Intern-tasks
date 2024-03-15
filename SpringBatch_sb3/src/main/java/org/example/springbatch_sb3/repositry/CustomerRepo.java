package org.example.springbatch_sb3.repositry;

import org.example.springbatch_sb3.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
