package ru.job4j.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class Customer {
    private int id;
    private String login;
    private String password;
    private String address;
    private String phoneNumber;
    private double balance;
    private List<Notification> notifications = new ArrayList<>();
    private Set<Order> orders = new HashSet<>();
    private Authority authority;
}
