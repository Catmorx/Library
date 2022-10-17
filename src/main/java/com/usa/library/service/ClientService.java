package com.usa.library.service;

import com.usa.library.model.ClientModel;
import com.usa.library.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClient() {
        return clientRepository.getAllClient();
    }

    public Optional<ClientModel> getClient(Integer idClient) {
        return clientRepository.getClient(idClient);
    }

    public ClientModel saveClient(ClientModel clientModel) {
        return clientRepository.saveClient(clientModel);
    }

    public boolean deleteClient(Integer idClient) {
        try {
            clientRepository.deleteClient(idClient);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ClientModel updateClient(ClientModel clientModel) {
        if (clientModel.getIdClient() != null) {
            Optional<ClientModel> client = clientRepository.getClient(clientModel.getIdClient());
            if (!client.isEmpty()) {
                if (clientModel.getEmail() != null) {
                    client.get().setEmail(clientModel.getEmail());
                }
                if (clientModel.getPassword() != null) {
                    client.get().setPassword(clientModel.getPassword());
                }
                if (clientModel.getName() != null) {
                    client.get().setName(clientModel.getName());
                }
                if (clientModel.getAge() != null) {
                    client.get().setAge(clientModel.getAge());
                }
                if (clientModel.getMessages() != null) {
                    client.get().setMessages(clientModel.getMessages());
                }
                if (clientModel.getReservations() != null) {
                    client.get().setReservations(clientModel.getReservations());
                }
                clientRepository.updateClient(client.get());
                return client.get();
            } else {
                return clientModel;
            }
        } else {
            return clientModel;
        }

    }
}
