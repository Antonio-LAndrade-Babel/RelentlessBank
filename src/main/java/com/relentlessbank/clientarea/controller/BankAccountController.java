package com.relentlessbank.clientarea.controller;

import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.service.BankAccountService;

import com.relentlessbank.clientarea.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountController {
    private final BankAccountService bankAccountService;
    private final ClientService clientService;
    public BankAccountController(BankAccountService bankAccountService, ClientService clientService) {
        this.bankAccountService = bankAccountService;
        this.clientService = clientService;
    }
    @PostMapping("/create")
    public ResponseEntity<BankAccount> createBankAccount(){
        //TODO
        return null;
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<BankAccount> updateBankAccount(){
        //TODO
        return null;
    }
    @PostMapping("/find")
    public ResponseEntity<BankAccount> getBankAccountById(){
        //TODO
        return null;
    }
    @PostMapping("/delete")
    public ResponseEntity<BankAccount> deleteBankAccount(){
        //TODO
        return null;
    }

}
