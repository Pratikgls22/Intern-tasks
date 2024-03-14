package org.example.springbatch.repositry;

import org.example.springbatch.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Serializable> {
}
