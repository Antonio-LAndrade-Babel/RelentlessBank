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
    private long id;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id")
    private BankAccount bankAccount;

    @ManyToOne
    @JoinColumn(name = "destinyAccountId", referencedColumnName = "id")
    private BankAccount destinyAccount;

    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    private String destinyIBAN;
    private LocalDateTime dateTime;
    private double operationAmount;
}