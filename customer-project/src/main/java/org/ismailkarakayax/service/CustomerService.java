package org.ismailkarakayax.service;


import org.ismailkarakayax.entity.Customer;

import java.util.ArrayList;
import java.util.Collections;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerService {

    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> findAllCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public List<Customer> findCustomersWithNameContainingC() {
        return customers.stream()
                .filter(customer -> customer.getName().toLowerCase().contains("c"))
                .toList();
    }

}
