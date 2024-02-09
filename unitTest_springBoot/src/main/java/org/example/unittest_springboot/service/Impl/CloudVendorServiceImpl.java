package org.example.unittest_springboot.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.unittest_springboot.exception.CloudVendorNotFoundException;
import org.example.unittest_springboot.model.CloudVendor;
import org.example.unittest_springboot.repositry.CloudVendorDao;
import org.example.unittest_springboot.requestDTO.CloudVendorRequestDTO;
import org.example.unittest_springboot.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CloudVendorServiceImpl implements CloudVendorService {

    private final CloudVendorDao cloudVendorDao;

    @Override
    public CloudVendor create(CloudVendorRequestDTO cloudVendorRequestDTO) {
        CloudVendor cloudVendor = new CloudVendor();
        cloudVendor.setName(cloudVendorRequestDTO.getName());
        cloudVendor.setAddress(cloudVendorRequestDTO.getAddress());
        cloudVendor.setPhone(cloudVendorRequestDTO.getPhone());
        return cloudVendorDao.save(cloudVendor);
    }

    @Override
    public List<CloudVendor> search() {
        return cloudVendorDao.findAll();
    }

    @Override
    public Optional<CloudVendor> searchId(Long id) {
        if (cloudVendorDao.findById(id).isEmpty()) {
            throw new CloudVendorNotFoundException("Request Cloud Vendor Doesn't Exist");
        }
        return cloudVendorDao.findById(id);
    }

    @Override
    public CloudVendor update(long id, CloudVendorRequestDTO cloudVendorRequestDTO) {
        Optional<CloudVendor> cloudVendor = cloudVendorDao.findById(id);
        cloudVendor.get().setName(cloudVendorRequestDTO.getName());
        cloudVendor.get().setAddress(cloudVendorRequestDTO.getAddress());
        cloudVendor.get().setPhone(cloudVendorRequestDTO.getPhone());
        return cloudVendorDao.save(cloudVendor.get());
    }

    @Override
    public CloudVendor delete(long id) {
        Optional<CloudVendor> vendor = cloudVendorDao.findById(id);
        if (vendor.isEmpty()) {
            throw new CloudVendorNotFoundException("Check your Id");
        } else {
            CloudVendor cloudVendor = vendor.get();
            cloudVendorDao.delete(cloudVendor);
            return cloudVendor;
        }
    }
}
