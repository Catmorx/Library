package com.usa.library.repository;

import com.usa.library.model.ClientModel;
import com.usa.library.repository.crudrepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<ClientModel> getAllClient() {
        return (List<ClientModel>) clientCrudRepository.findAll();
    }

    public Optional<ClientModel> getClient(Integer idClient) {
        return clientCrudRepository.findById(idClient);
    }

    public ClientModel saveClient(ClientModel clientModel) {
        return clientCrudRepository.save(clientModel);
    }

    public void deleteClient(Integer id){
        clientCrudRepository.deleteById(id);
    }
    public void updateClient(ClientModel clientModel){
        clientCrudRepository.save(clientModel);
    }

}
