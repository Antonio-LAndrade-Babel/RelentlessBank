package com.relentlessbank.clientarea.controller;

import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.service.BankAccountService;

import com.relentlessbank.clientarea.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }
    @PostMapping("/create/{clientId}")
    public ResponseEntity<BankAccount> createBankAccount(@PathVariable int clientId, @RequestBody BankAccount bankAccount) {
        BankAccount newBankAccount = bankAccountService.createBankAccount(clientId, bankAccount);
        return ResponseEntity.ok(newBankAccount);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<BankAccount> updateBankAccount(@PathVariable int id, @RequestBody BankAccount bankAccountDetails) {
        BankAccount bankAccount = bankAccountService.updateBankAccount(id, bankAccountDetails);
        return ResponseEntity.ok(bankAccount);
    }
    @PostMapping("/find/{id}")
    public ResponseEntity<BankAccount> getBankAccountById(@PathVariable int id){
        BankAccount bankAccount = bankAccountService.getBankAccountById(id);
        return ResponseEntity.ok(bankAccount);
    }
    @PostMapping("/findallbyclient/{clientId}")
    public ResponseEntity<List<BankAccount>> getAllBankAccountByClient(@PathVariable int clientId) {
        List<BankAccount> bankAccounts = bankAccountService.getAllBankAccountByClient(clientId);
        return ResponseEntity.ok(bankAccounts);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<BankAccount> deleteBankAccount(@PathVariable int id) {
        bankAccountService.deleteBankAccount(id);
        return ResponseEntity.ok().build();
    }

}
