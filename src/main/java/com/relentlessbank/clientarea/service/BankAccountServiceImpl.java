package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.model.Client;
import com.relentlessbank.clientarea.repository.BankAccountRepository;
import com.relentlessbank.clientarea.repository.ClientRepository;

import java.util.List;

public class BankAccountServiceImpl implements BankAccountService {
    private final ClientRepository clientRepository;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(ClientRepository clientRepository, BankAccountRepository bankAccountRepository) {
        this.clientRepository = clientRepository;
        this.bankAccountRepository = bankAccountRepository;
    }
    @Override
    public BankAccount createBankAccount(int clientId, BankAccount bankAccount) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        bankAccount.setClient(client);
        client.getBankAccounts().add(bankAccount);
        return bankAccountRepository.save(bankAccount);
    }
    @Override
    public BankAccount updateBankAccount(int id, BankAccount bankAccountDetails) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado ninguna cuenta con ID: " + id));
        if (bankAccountDetails.getAccountIBAN() != null) bankAccount.setAccountIBAN(bankAccountDetails.getAccountIBAN());
        if (bankAccountDetails.getAccountBalance() != null) bankAccount.setAccountBalance(bankAccountDetails.getAccountBalance());
        return bankAccountRepository.save(bankAccount);
    }
    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }
    @Override
    public BankAccount getBankAccountById(int id) {
        return bankAccountRepository.findById(id).orElseThrow(() -> new RuntimeException ("No se ha encontrado ninguna cuenta con ID: " + id));
    }
    @Override
    public List<BankAccount> getAllBankAccountByClient(int clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("No existe ningún cliente con la ID: " + clientId));
        return bankAccountRepository.findAllByClient(client);
    }
    @Override
    public void deleteBankAccount(int id) {
        BankAccount bankAccount = getBankAccountById(id);
        bankAccountRepository.delete(bankAccount);
    }
}
