package ru.job4j.model;

import lombok.Data;

@Data
public class Payment {

    private int id;
    private double currentPrice;
    private  boolean acceptStatus;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
