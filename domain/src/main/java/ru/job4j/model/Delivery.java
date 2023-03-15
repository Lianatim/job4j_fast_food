package ru.job4j.model;

import lombok.Data;

@Data
public class Delivery {

    private int id;
    private String deliveryName;
    private String street;
    private String city;
    private int phoneNumber;

}
