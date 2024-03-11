package com.relentlessbank.clientarea.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private Client client;

    private String accountIBAN;
    private Double accountBalance;

    @OneToMany(mappedBy = "bankAccount")
    private Set<Operation> operations;
}