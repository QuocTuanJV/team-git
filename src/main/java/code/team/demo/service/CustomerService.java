package code.team.demo.service;

import code.team.demo.model.Customer;

public interface CustomerService {
    Iterable<Customer> findAll();

    Customer save(Customer customer);
}
