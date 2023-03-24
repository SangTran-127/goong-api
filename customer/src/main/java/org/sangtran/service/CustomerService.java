package org.sangtran.service;

import org.sangtran.entity.Customer;
import org.sangtran.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
@EnableJpaRepositories
@Service
public class CustomerService {
    @Autowired(required = false)
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomer() {
        return this.customerRepository.findAll();
    }
}
