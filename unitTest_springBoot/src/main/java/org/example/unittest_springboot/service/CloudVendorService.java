//Service layer Also called Business Layer

package org.example.unittest_springboot.service;

import org.example.unittest_springboot.model.CloudVendor;
import org.example.unittest_springboot.requestDTO.CloudVendorRequestDTO;

import java.util.List;
import java.util.Optional;

public interface CloudVendorService {
    CloudVendor create(CloudVendorRequestDTO cloudVendorRequestDTO);

    List<CloudVendor> search();

    Optional<CloudVendor> searchId(Long id);


    CloudVendor update(long id, CloudVendorRequestDTO cloudVendorRequestDTO);

    CloudVendor delete(long id);
}
