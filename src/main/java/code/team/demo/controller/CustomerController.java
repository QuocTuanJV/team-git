package code.team.demo.controller;

import code.team.demo.model.Customer;
import code.team.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list-customer")
    public ResponseEntity<Iterable<Customer>> getCustomer(){
        Iterable<Customer> customers = customerService.findAll();
        return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
    }

    @PostMapping("/create-customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        Customer customerInsert = customerService.save(customer);
        return new ResponseEntity<>(customerInsert, HttpStatus.CREATED);
    }
}
