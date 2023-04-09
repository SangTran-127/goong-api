package org.sangtran.service;

import org.sangtran.dto.AddCustomerDto;
import org.sangtran.dto.LoginCustomerDto;
import org.sangtran.entity.Role;
import org.sangtran.entity.User;
import org.sangtran.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllCustomer() {
        return this.userRepository.findAll();
    }
    public User getCustomerByEmailAndPassword(LoginCustomerDto loginCustomerDto) throws Exception {
        var holderUser = this.userRepository.findByEmail(loginCustomerDto.email());
        if (holderUser.isPresent()) {
            if (holderUser.get().getPassword().equals(loginCustomerDto.password())) {
                return holderUser.get();
            } else {
                throw new Exception("Wrong password");
            }
        } else {
            throw new Exception("User is not register yet");
        }
    }

    public User addCustomer(AddCustomerDto addCustomerDto) {
        var user = User.builder()
                .lastName(addCustomerDto.lastName)
                .firstName(addCustomerDto.firstName)
                .password(addCustomerDto.password)
                .role(Role.USER)
                .email(addCustomerDto.email)
                .build();
        return this.userRepository.save(user);
    }
}
