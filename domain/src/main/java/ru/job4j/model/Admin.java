package ru.job4j.model;

import lombok.Data;

@Data
public class Admin {

    private  int id;
    private String login;
    private String password;
    private Authority authority;
}
