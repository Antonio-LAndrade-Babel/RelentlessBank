package com.relentlessbank.clientarea.model;

import com.relentlessbank.clientarea.enums.OperationType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private BankAccount account;

    @ManyToOne
    @JoinColumn(name = "destinyAccountId", referencedColumnName = "id")
    private BankAccount destinyAccount;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    private LocalDateTime dateTime;
    private double operationAmount;
}