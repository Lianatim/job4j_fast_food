package ru.job4j.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.dto.CustomerDTORequest;
import ru.job4j.dto.CustomerDTOResponse;
import ru.job4j.model.Customer;
import ru.job4j.service.CustomerService;

import javax.validation.Valid;

@RestController
public class CustomerController {
    private final CustomerService customerService;
    private final ModelMapper modelMapper;

    public CustomerController(CustomerService customerService, ModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDTOResponse> save(@RequestBody @Valid CustomerDTORequest customerDTORequest) {
        CustomerDTOResponse customerDTOResponse = convertToCustomerDTO(customerService.save(convertToCustomer(customerDTORequest)));
        return new ResponseEntity<>(customerDTOResponse,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/buyCard")
    public ResponseEntity<Customer> buyCard(@RequestBody @Valid CustomerDTORequest customerDTORequest) {
        Customer customerUpdate = customerService.buyCard(convertToCustomer(customerDTORequest));
        return new ResponseEntity<>(customerUpdate, HttpStatus.OK);
    }

    private CustomerDTOResponse convertToCustomerDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTOResponse.class);
    }

    private Customer convertToCustomer(CustomerDTORequest customerDTORequest) {
        return modelMapper.map(customerDTORequest, Customer.class);
    }
}
