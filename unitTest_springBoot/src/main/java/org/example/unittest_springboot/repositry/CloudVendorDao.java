package org.example.unittest_springboot.repositry;

import org.example.unittest_springboot.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CloudVendorDao extends JpaRepository<CloudVendor,Long> {

}
