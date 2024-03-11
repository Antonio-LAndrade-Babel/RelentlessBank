package com.relentlessbank.clientarea.repository;

import com.relentlessbank.clientarea.model.Operation;
import com.relentlessbank.clientarea.model.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository <Operation, Long> {
    List<Operation> findAllByBankAccount(BankAccount bankAccount);
}
