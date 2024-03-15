package org.example.partition_springbatch.config;

import org.example.partition_springbatch.entity.Customer;
import org.example.partition_springbatch.repositry.CustomerRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CustomerWriter implements ItemWriter<Customer> {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public void write(List<? extends Customer> list) throws Exception {
        System.out.println("Thred Name:-"+Thread.currentThread().getName());
        customerRepo.saveAll(list);
    }
}
