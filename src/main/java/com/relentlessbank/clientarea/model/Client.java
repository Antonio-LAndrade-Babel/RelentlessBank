package com.relentlessbank.clientarea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String surname;
    private String lastName;

    @OneToMany(mappedBy = "client")
    private Set<BankAccount> bankAccounts;
}