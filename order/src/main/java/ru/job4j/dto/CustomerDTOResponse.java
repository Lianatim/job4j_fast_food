package ru.job4j.dto;

import ru.job4j.model.Card;
import ru.job4j.model.Notification;
import ru.job4j.model.Order;

import java.util.ArrayList;
import java.util.List;

public class CustomerDTOResponse {

    private String login;
    private String address;
    private int phoneNumber;
    private double balance;
    private List<Notification> notifications = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private Card card;
}
