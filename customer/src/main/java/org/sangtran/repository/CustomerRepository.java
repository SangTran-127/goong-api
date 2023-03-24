package org.sangtran.repository;

import org.sangtran.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface CustomerRepository extends MongoRepository<Customer, String> {
    List<Customer> findAll();

}
