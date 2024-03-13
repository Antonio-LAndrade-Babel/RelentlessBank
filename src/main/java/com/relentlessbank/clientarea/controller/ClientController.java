package com.relentlessbank.clientarea.controller;

import com.relentlessbank.clientarea.service.ClientService;
import com.relentlessbank.clientarea.model.Client;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;
    private static final Logger logger = LogManager.getLogger(ClientController.class);
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }
    @PostMapping("/create")
    public ResponseEntity<Client> createClient (@RequestBody Client client){
        Client newClient = clientService.createClient(client);
        logger.info("Se ha creado un nuevo cliente [ID = " + newClient.getId() + "].");
        return ResponseEntity.ok(newClient);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient (@PathVariable int id, @RequestBody Client clientDetails){
        Client updatedClient = clientService.updateClient(id, clientDetails);
        logger.info("Se ha hecho una actualización del cliente [ID = " + id + "].");
        return ResponseEntity.ok(updatedClient);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Client> getClientById (@PathVariable int id) {
        Client client = clientService.getClientById(id);
        logger.info("Se ha hecho una búsqueda sobre el cliente [ID = " + id + "].");
        return ResponseEntity.ok().body(client);
    }
    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteClient (@PathVariable int id){
        logger.info("Se ha solicitado la eliminación del cliente [ID = " + id + "].");
        clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}