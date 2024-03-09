package com.relentlessbank.clientarea.controller;

import com.relentlessbank.clientarea.service.ClientService;
import com.relentlessbank.clientarea.model.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/create")
    public ResponseEntity<Client> createClient (@RequestBody Client client){
        Client newClient = clientService.createClient(client);
        return ResponseEntity.ok(newClient);
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Client> updateClient (@PathVariable int id, @RequestBody Client clientDetails){
        Client updatedClient = clientService.updateClient(id, clientDetails);
        return ResponseEntity.ok(updatedClient);
    }
    @PostMapping("/find/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable int id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok().body(client);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient (@PathVariable int id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}