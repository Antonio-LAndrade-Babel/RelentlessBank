package com.relentlessbank.clientarea.repository;

import com.relentlessbank.clientarea.model.BankAccount;
import com.relentlessbank.clientarea.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {
    BankAccount findByIban(String iban);
    List<BankAccount> findAllByClient(Client client);
}
