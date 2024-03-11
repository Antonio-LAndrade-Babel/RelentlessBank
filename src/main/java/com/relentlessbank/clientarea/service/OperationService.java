package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.Operation;

import java.util.List;

public interface OperationService {
    Operation createOperation(int accountId, Operation operation);
    List<Operation> getAllOperationsByBankAccount(int accountId);
    void deleteOperation(int id);
}