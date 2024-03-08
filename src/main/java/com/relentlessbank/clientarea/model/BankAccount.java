package com.relentlessbank.clientarea.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BankAccount {
    private int id;
    private int clientId;
    private String accountIBAN;
    private double accountBalance;
}
