package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.model.Operation;
import com.relentlessbank.clientarea.repository.BankAccountRepository;
import com.relentlessbank.clientarea.repository.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {
    private final OperationRepository operationRepository;
    private final BankAccountRepository bankAccountRepository;

    public OperationServiceImpl(OperationRepository operationRepository, BankAccountRepository bankAccountRepository) {
        this.operationRepository = operationRepository;
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Operation createOperation(int accountId, Operation operation) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("No existe una cuenta con la ID: " + accountId));
        operation.setBankAccount(bankAccount);
        bankAccount.getOperations().add(operation);
        //TODO: lógica para encontrar si el IBAN de destino es de la misma entidad.
        return null;
    }
    @Override
    public List<Operation> getAllOperationsByBankAccount(int accountId) {
        return null;
    }
    @Override
    public void deleteOperation(long id) {

    }
}
