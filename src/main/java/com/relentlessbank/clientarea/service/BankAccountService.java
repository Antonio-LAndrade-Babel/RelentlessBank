package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.BankAccount;

import java.util.List;

public interface BankAccountService {
    BankAccount createBankAccount (int clientId, BankAccount bankAccount);
    BankAccount updateBankAccount (int id, BankAccount bankAccount);
    List<BankAccount> getAllBankAccounts();
    BankAccount getBankAccountById(int id);
    BankAccount getBankAccountByIban(String iban);
    List<BankAccount> getAllBankAccountByClient(int clientId);
    void deleteBankAccount(int id);
}
