package com.usa.library.service;

import com.usa.library.model.MessageModel;
import com.usa.library.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessage() {
        return messageRepository.getAllMessage();
    }

    public Optional<MessageModel> getMessage(Integer idMessage) {
        return messageRepository.getMessage(idMessage);
    }

    public MessageModel saveMessage(MessageModel messageModel) {
        return messageRepository.saveMessage(messageModel);
    }

    public boolean deleteMessage(Integer idMessage) {
        try {
            messageRepository.deleteMessage(idMessage);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public MessageModel updateMessage(MessageModel messageModel) {
        if (messageModel.getIdMessage() != null) {
            Optional<MessageModel> message = messageRepository.getMessage(messageModel.getIdMessage());
            if (!message.isEmpty()) {
                if (messageModel.getMessageText() != null) {
                    message.get().setMessageText(messageModel.getMessageText());
                }
                if (messageModel.getLib() != null) {
                    message.get().setLib(messageModel.getLib());
                }
                if (messageModel.getClient() != null) {
                    message.get().setClient(messageModel.getClient());
                }
                messageRepository.updateMessage(message.get());
                return message.get();
            } else {
                return messageModel;
            }
        } else {
            return messageModel;
        }

    }

}
