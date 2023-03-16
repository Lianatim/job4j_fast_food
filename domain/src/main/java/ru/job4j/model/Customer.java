package ru.job4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Customer {

    @EqualsAndHashCode.Include
    private int id;
    private String login;
    private String password;
    private String address;
    private int phoneNumber;
    private double balance;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notification")
    private List<Notification> notifications = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<Order> orders = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "authority_id")
    private Authority authority;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phoneNumber")
    private Card card;
}
