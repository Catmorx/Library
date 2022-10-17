package com.usa.library.repository;


import com.usa.library.model.MessageModel;
import com.usa.library.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAllMessage() {
        return (List<MessageModel>) messageCrudRepository.findAll();
    }

    public Optional<MessageModel> getMessage(Integer idMessage) {
        return messageCrudRepository.findById(idMessage);
    }

    public MessageModel saveMessage(MessageModel messageModel) {
        return messageCrudRepository.save(messageModel);
    }

    public void updateMessage(MessageModel messageModel){
        messageCrudRepository.save(messageModel);
    }
    public void deleteMessage(Integer id){
        messageCrudRepository.deleteById(id);
    }
}
