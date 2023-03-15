package ru.job4j.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Notification {

    private int id;
    private String message;
    private LocalDateTime created;
    private boolean deliveredStatus;
}
