package org.sangtran.service;

import org.sangtran.entity.Customer;
import org.sangtran.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }
//    public Customer addCustomer() {
//        return this.customerRepository.insert();
//    }
}
