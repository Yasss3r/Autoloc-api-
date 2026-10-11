package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    Client addClient(Client client);

    Client updateClient(Client client);

    void deleteClient(Long id);

    List<Client> findAllClients();

    Optional<Client> findClientById(Long id);
}
