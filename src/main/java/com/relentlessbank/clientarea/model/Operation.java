package com.relentlessbank.clientarea.model;

import com.relentlessbank.clientarea.enums.OperationType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Operation {
    private int id;
    private int bankAccountId;
    private int destinyAccountId;
    private LocalDateTime dateTime;
    private OperationType operationType;
    private double operationAmount;
}