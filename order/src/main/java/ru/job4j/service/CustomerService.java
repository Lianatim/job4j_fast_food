package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.model.Card;
import ru.job4j.model.Customer;
import ru.job4j.repository.CustomerRepository;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer buyCard(Customer customer) {
        customer.setCard(new Card(customer.getPhoneNumber(), 0));
        return customerRepository.save(customer);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
