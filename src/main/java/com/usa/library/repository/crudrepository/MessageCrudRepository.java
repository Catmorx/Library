package com.usa.library.repository.crudrepository;


import com.usa.library.model.MessageModel;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<MessageModel, Integer> {

}
