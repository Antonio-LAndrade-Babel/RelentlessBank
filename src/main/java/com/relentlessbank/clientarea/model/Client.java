package com.relentlessbank.clientarea.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Client {
    private int id;
    private String username;
    private String password;
    private String surname;
    private String lastName;
}
