package ru.job4j.model;

import lombok.Data;

@Data
public class Dish {

    private int id;
    private String name;
    private String description;
    private double price;
}
