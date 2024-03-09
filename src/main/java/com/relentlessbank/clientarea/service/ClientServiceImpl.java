package com.relentlessbank.clientarea.service;

import com.relentlessbank.clientarea.model.Client;
import com.relentlessbank.clientarea.repository.ClientRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }
    @Override
    public Client updateClient(int id, Client clientDetails) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado ningún cliente con la ID :: " + id));
        if (clientDetails.getUsername() != null) client.setUsername(clientDetails.getUsername());
        if (clientDetails.getPassword() != null) client.setPassword(clientDetails.getPassword());
        if (clientDetails.getSurname() != null) client.setSurname(clientDetails.getSurname());
        if (clientDetails.getLastName()!= null) client.setLastName(clientDetails.getLastName());
        return clientRepository.save(client);
    }
    @Override
    public List<Client> gelAllClients() {
        return clientRepository.findAll();
    }
    @Override
    public Client getClientById(int id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("No se ha encontrado ningún cliente con la ID :: " + id));
    }
    @Override
    public void deleteClient(int id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
