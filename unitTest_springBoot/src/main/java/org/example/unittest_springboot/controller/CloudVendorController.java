package org.example.unittest_springboot.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.unittest_springboot.model.CloudVendor;
import org.example.unittest_springboot.requestDTO.CloudVendorRequestDTO;
import org.example.unittest_springboot.service.CloudVendorService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendor")
public class CloudVendorController {

    private final CloudVendorService cloudVendorService;

    @PostMapping("/add")
    public CloudVendor create(@Valid @RequestBody CloudVendorRequestDTO cloudVendorRequestDTO){
        return cloudVendorService.create(cloudVendorRequestDTO);
    }

    @GetMapping("/search")
    public List<CloudVendor> search(){
        return cloudVendorService.search();
    }

    @GetMapping("/search/{id}")
    public Optional<CloudVendor> searchId(@PathVariable Long id){
        return cloudVendorService.searchId(id);
    }

    @PutMapping("/update/{id}")
                                // check when we write @valid this annotation also with requestBody.....
    public CloudVendor update(@PathVariable long id, @Valid @RequestBody CloudVendorRequestDTO cloudVendorRequestDTO){
        return cloudVendorService.update(id,cloudVendorRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public CloudVendor delete(@PathVariable long id){
        return cloudVendorService.delete(id);
    }

}
