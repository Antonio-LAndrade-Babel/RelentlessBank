package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.Client;

import java.util.List;

public interface ClientService {
    Client createClient (Client client);
    Client updateClient (int id, Client client);
    List<Client> gelAllClients();
    Client getClientById(int id);
    void deleteClient(int id);
}
