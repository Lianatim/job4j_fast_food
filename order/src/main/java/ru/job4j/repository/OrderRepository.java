package ru.job4j.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.model.Customer;
import ru.job4j.model.Order;
import ru.job4j.model.Status;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllByCustomer(Customer customer);

    Status findStatusByOrderId(int orderId);

}
