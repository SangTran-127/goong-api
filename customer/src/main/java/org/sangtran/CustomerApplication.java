package org.sangtran;


import lombok.extern.slf4j.Slf4j;
import org.sangtran.entity.Customer;
import org.sangtran.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@SpringBootApplication
@EnableMongoRepositories
public class CustomerApplication implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
    @Override
    public void run(String ...args) throws Exception {
      log.info("Running");
      Customer c = customerRepository.save(new Customer("Sang"));
      log.info(String.valueOf(c.get_id()));
    }
}
