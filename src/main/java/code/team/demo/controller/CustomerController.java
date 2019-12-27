package code.team.demo.controller;

import code.team.demo.model.Customer;
import code.team.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping
    ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = customerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        if (customer.isPresent()) {
            customerService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
        @GetMapping("/list-customer")
        public ResponseEntity<Iterable<Customer>> getCustomer() {
            Iterable<Customer> customers = customerService.findAll();
            return new ResponseEntity<Iterable<Customer>>(customers, HttpStatus.OK);
        }

        @PostMapping("/create-customer")
        public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
            Customer customerInsert = customerService.save(customer);
            return new ResponseEntity<>(customerInsert, HttpStatus.CREATED);

    }
}
