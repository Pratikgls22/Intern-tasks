package org.example.unittest_springboot.service.Impl;

import org.example.unittest_springboot.model.CloudVendor;
import org.example.unittest_springboot.repositry.CloudVendorDao;
import org.example.unittest_springboot.requestDTO.CloudVendorRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CloudVendorServiceImplTest {

    @Mock
    private CloudVendorDao cloudVendorDao;
    @InjectMocks
    private CloudVendorServiceImpl cloudVendorService;


    @Test
    void create() {
        //Request
        CloudVendorRequestDTO mockCV = new CloudVendorRequestDTO();
        mockCV.setName("trup");
        mockCV.setAddress("bapunagar");
        mockCV.setPhone("7894561232");

        CloudVendor vendor = new CloudVendor();
        vendor.setId(1L);
        vendor.setPhone("7894561232");
        vendor.setName("trup");
        vendor.setAddress("bapunagar");
        //Mocks

        //Mocking
        when(cloudVendorDao.save(vendor)).thenReturn(vendor);

        //Test
        CloudVendor cloudVendor = cloudVendorService.create(mockCV);
        System.out.println("cloudVendor = " + cloudVendor);

        //Assertion
        verify(cloudVendorDao, Mockito.times(1)).save(vendor);
        assertEquals(vendor,cloudVendor);
    }

    @Test
    void search() {
    }

    @Test
    void searchId() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}