package code.team.demo.service;

import code.team.demo.model.Customer;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Long id);
    void delete(Long id);
    void save(Customer customer);
    List<Customer> findAll();
}
