package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.enums.OperationType;
import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.model.Operation;
import com.relentlessbank.clientarea.repository.BankAccountRepository;
import com.relentlessbank.clientarea.repository.OperationRepository;

import jakarta.transaction.Transactional;
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
    @Transactional
    public Operation createOperation(int accountId, Operation operation) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("No existe una cuenta con la ID: " + accountId));
        operation.setBankAccount(bankAccount);
        bankAccount.getOperations().add(operation);
        calculateNewAccountBalance(operation, bankAccount);
        if (operation.getOperationType() == OperationType.TRANSFER) if (isInternalAccount(operation.getDestinyIBAN())) createDestinyInternalOperation(operation);
        return operationRepository.save(operation);
    }
    @Override
    public Operation getOperationById(long id){
        return operationRepository.findById(id).orElseThrow(() -> new RuntimeException("No existe ninguna cuenta con la ID: " + id));
    }
    @Override
    public List<Operation> getAllOperationsByBankAccount(int accountId) {
        BankAccount bankAccount = bankAccountRepository.findById(accountId).orElseThrow(() -> new RuntimeException("No existe una cuenta con la ID: " + accountId));
        return operationRepository.findAllByBankAccount(bankAccount);
    }
    @Override
    public void deleteOperation(long id) {
        Operation operation = getOperationById(id);
        operationRepository.delete(operation);
    }

    private void createDestinyInternalOperation(Operation operation){
        Operation destinyOperation = new Operation();
        BankAccount destinyBankAccount = bankAccountRepository.findByIban(operation.getDestinyIBAN());
        destinyOperation.setBankAccount(destinyBankAccount);
        destinyOperation.setOriginIBAN(operation.getBankAccount().getAccountIBAN());
        destinyOperation.setDestinyIBAN(null);
        destinyOperation.setDateTime(operation.getDateTime());
        destinyOperation.setOperationAmount(operation.getOperationAmount() * -1);
        createOperation(destinyBankAccount.getId(), destinyOperation);
    }

    private void calculateNewAccountBalance(Operation operation, BankAccount bankAccount){
        bankAccount.setAccountBalance(bankAccount.getAccountBalance() + operation.getOperationAmount());
        bankAccountRepository.save(bankAccount);
    }

    private boolean isInternalAccount(String iban){
        //Vamos a usar un código inventado, digamos, 9292.
        return iban.startsWith("ES219292");
    }
}