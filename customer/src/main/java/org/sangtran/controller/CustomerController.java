package org.sangtran.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.sangtran.dto.AddCustomerDto;
import org.sangtran.entity.Customer;
import org.sangtran.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomer() {
        return new ResponseEntity<>(this.customerService.getAllCustomer(), HttpStatusCode.valueOf(200));
    }
    @PostMapping()
    public void addCustomer(@RequestBody @Valid AddCustomerDto customerDto) {
      log.info(customerDto.email);
    }
}
