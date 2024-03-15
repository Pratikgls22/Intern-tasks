package org.example.springbatch_sb3.config;

import org.example.springbatch_sb3.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        return customer;
    }
}
