package org.sangtran.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.sangtran.dto.AddCustomerDto;
import org.sangtran.dto.LoginCustomerDto;
import org.sangtran.entity.User;
import org.sangtran.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService customerService;
    @GetMapping()
    public ResponseEntity<List<User>> getAllCustomer() {
        return new ResponseEntity<>(this.customerService.getAllCustomer(), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginCustomerDto loginCustomerDto) throws Exception {
        return ResponseEntity.ok(this.customerService.getCustomerByEmailAndPassword(loginCustomerDto));
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody AddCustomerDto customerDto) {
        return ResponseEntity.ok(this.customerService.addCustomer(customerDto));
    }
}
