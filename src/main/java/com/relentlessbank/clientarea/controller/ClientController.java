package com.relentlessbank.clientarea.controller;

import com.relentlessbank.clientarea.service.ClientService;
import com.relentlessbank.clientarea.model.Client;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClientController {
    private final ClientService clientService;
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/create")
    public Client createClient (@RequestBody Client client){
        return clientService.createClient(client);
    }
    @PostMapping("/update/{id}")
    public Client updateClient (@PathVariable(value = "id") int id, @RequestBody Client clientDetails){
        return clientService.updateClient(id, clientDetails);
    }
    @PostMapping("/find")
    public ResponseEntity<Client> getClientById (@RequestBody int id) {
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok().body(client);
    }
    @PostMapping("/delete")
    public ResponseEntity<?> deleteClient (@RequestBody int id){
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
