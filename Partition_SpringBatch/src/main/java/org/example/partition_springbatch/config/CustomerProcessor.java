package org.example.partition_springbatch.config;

import org.example.partition_springbatch.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer,Customer> {
    @Override
    public Customer process(Customer item) throws Exception {
        //logic
//        if (item.getCountry().equals("India")){
//            return item;
//        }else {
//            return null;
//        }
        return item;
    }
}
