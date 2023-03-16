package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
