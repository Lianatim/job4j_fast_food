package ru.job4j.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.model.Customer;
import ru.job4j.model.Order;
import ru.job4j.model.Status;
import ru.job4j.service.OrderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody @Valid Order order) {
        return new ResponseEntity<>(orderService.save(order),
                HttpStatus.CREATED
        );
    }

    @GetMapping ("/all")
    public ResponseEntity<List<Order>> findAllByCustomer(@RequestBody @Valid Customer customer) {
        return new ResponseEntity<>(orderService.findAllByCustomer(customer),
                HttpStatus.OK);
    }

    @GetMapping ("/info/{id}")
    public ResponseEntity<Order> findInfoByOrder(@PathVariable("id") int id) {
        return new ResponseEntity<>(orderService.findOrderById(id),
                HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Status> checkStatus(@PathVariable("id") int id) {
        return new ResponseEntity<>(orderService.findStatusByOrderId(id),
                HttpStatus.OK);
    }
}
