package ru.job4j.service;

import org.springframework.stereotype.Service;
import ru.job4j.exception.ResourceNotFoundException;
import ru.job4j.model.Courier;
import ru.job4j.model.Customer;
import ru.job4j.model.Order;
import ru.job4j.model.Status;
import ru.job4j.repository.CourierRepository;
import ru.job4j.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;

    public OrderService(OrderRepository orderRepository, CourierRepository courierRepository) {
        this.orderRepository = orderRepository;
        this.courierRepository = courierRepository;
    }

    public Order save(Order order) {
        order.setStatus(Status.ACCEPTED);
        Courier courier = findFreeCourier().orElseThrow(() -> new ResourceNotFoundException("Повторите попытку позже, все курьеры заняты"));
        order.setCourier(courier);
        return orderRepository.save(order);
    }

    private Optional<Courier> findFreeCourier() {
        return courierRepository.findByStatus("FREE");
    }

    public List<Order> findAllByCustomer(Customer customer) {
        return orderRepository.findAllByCustomer(customer);
    }

    public Order findOrderById(int id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Данный заказ не зарегистрирован в системе"));
        return order;
    }

    public Status findStatusByOrderId(int orderId) {
       return orderRepository.findStatusByOrderId(orderId);
    }
}
