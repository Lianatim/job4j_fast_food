package ru.job4j.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Courier {

    private int id;
    private String login;
    private String password;
    private String address;
    private String phoneNumber;
    private List<Notification> notifications = new ArrayList<>();
    private Authority authority;
}
