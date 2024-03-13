package com.relentlessbank.clientarea.controller;

import com.relentlessbank.clientarea.model.Operation;
import com.relentlessbank.clientarea.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/operation")
public class OperationController {
    private final OperationService operationService;
    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }
    @PostMapping("create/{accountId}")
    public ResponseEntity<Operation> createOperation(@PathVariable int accountId, @RequestBody Operation operation){
        Operation newOperation = operationService.createOperation(accountId, operation);
        return ResponseEntity.ok(newOperation);
    }
    @GetMapping("find/{id}")
    public ResponseEntity<Operation> getOperationById(@PathVariable long id){
        Operation operation = operationService.getOperationById(id);
        return ResponseEntity.ok(operation);
    }
    @GetMapping("findallbybankaccount/{accountId}")
    public ResponseEntity<List<Operation>> getAllOperationsByBankAccount(@PathVariable int accountId){
        List<Operation> operations = operationService.getAllOperationsByBankAccount(accountId);
        return ResponseEntity.ok(operations);
    }
    @PostMapping("delete/{id}")
    public ResponseEntity<Operation> deleteOperation(@PathVariable long id){
        operationService.deleteOperation(id);
        return ResponseEntity.ok().build();
    }
}
