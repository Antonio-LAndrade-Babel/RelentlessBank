package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.model.Client;

import java.util.List;

public interface BankAccountService {
    BankAccount createBankAccount (int clientId, BankAccount bankAccount);
    BankAccount updateBankAccount (int id, BankAccount bankAccount);
    List<BankAccount> getAllBankAccounts();
    BankAccount getBankAccountById(int id);
    List<BankAccount> getAllBankAccountByClient(int clientId);
    void deleteBankAccount(int id);
}
