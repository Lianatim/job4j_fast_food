package ru.job4j.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {

    private int id;
    private boolean acceptStatus;
    private boolean paymentStatus;
    private List<Dish> dishes = new ArrayList<>();

}
