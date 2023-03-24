package org.sangtran.service;

import org.sangtran.entity.User;
import org.sangtran.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
@EnableJpaRepositories
@Service
public class CustomerService {
    @Autowired(required = false)
    private UserRepository userRepository;
    public List<User> getAllCustomer() {
        return this.userRepository.findAll();
    }
}
