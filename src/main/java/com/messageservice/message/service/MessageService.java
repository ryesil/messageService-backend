package com.messageservice.message.service;


import com.messageservice.message.exception.ResourceNotFoundException;
import com.messageservice.message.model.Message;
import com.messageservice.message.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@AllArgsConstructor
@Service
public class MessageService {

@Autowired
private MessageRepository messageRepository;

    public Message createMessage(Message message){
        return messageRepository.save(message);
    }

    public List<Message> getMessages(){
        return messageRepository.findAll();
    }

    public Message getMessage(Long id){
        Message message = messageRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("There is no message with the given ID "+ id));
        return message;
    }

   public Message updateMessage(Long id, Message message){
        Message messageFromDatabase = messageRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(String.format("There is no message with the given id %d",id)));
            messageFromDatabase.setSubject(message.getSubject());
            messageFromDatabase.setBody(message.getBody());
            messageFromDatabase.setEmail(message.getEmail());
            messageFromDatabase.setPhoneNumber(message.getPhoneNumber());
            messageFromDatabase.setTimestamp(message.getTimestamp());
            messageRepository.save(messageFromDatabase);
            return messageFromDatabase;
   }

}
