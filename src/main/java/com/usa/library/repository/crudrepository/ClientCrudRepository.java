package com.usa.library.repository.crudrepository;


import com.usa.library.model.ClientModel;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<ClientModel, Integer> {

}
