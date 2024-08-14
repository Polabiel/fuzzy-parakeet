package com.cotuca.controllers;

import com.cotuca.models.Customer;
import com.cotuca.repositores.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @GetMapping
    public List<Customer> getCustomers() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerController that)) return false;
        return Objects.equals(repository, that.repository);
    }

    @Override
    public String toString() {
        return "CustomerController{" +
                "repository=" + repository +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(repository);
    }

    @Autowired
    private CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> All() {
        return repository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Optional<Customer> getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @PostMapping
    public Customer save(@RequestBody Customer newCustomer) {
        return repository.save(newCustomer);
    }

    @PutMapping
    public Customer update(@RequestBody Customer newCustomer, @PathVariable Integer id) {
        Optional<Customer> oldCustomer = repository.findById(id);
        if (oldCustomer.isPresent()) {
            Customer c = oldCustomer.get();
            c.setName(newCustomer.getName());
            c.setEmail(newCustomer.getEmail());
            c.setLatitude(newCustomer.getLatitude());
            c.setLongitude(newCustomer.getLongitude());
            repository.save(c);
        }
        return newCustomer;
    }
}