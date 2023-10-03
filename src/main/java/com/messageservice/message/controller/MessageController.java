package com.messageservice.message.controller;


import com.messageservice.message.model.Message;
import com.messageservice.message.service.MessageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping
public class MessageController {

    private static Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @PostMapping("/new")
    public ResponseEntity<Message> createMessage(@Valid @RequestBody Message message){
        Message savedMessage = messageService.createMessage(message);
        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }


    @GetMapping("/messages")
    private ResponseEntity<List<Message>> getMessages(){
        List<Message> messageList = messageService.getMessages();
        return new ResponseEntity<>(messageList,HttpStatus.OK);
    }

    @GetMapping("messages/{id}")
    private ResponseEntity<Message> getMessage(@PathVariable Long id){
        Message message =  messageService.getMessage(id);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/messages/{id}")
    private ResponseEntity<Message> updateMessage(@PathVariable Long id,  @Valid @RequestBody Message message){
     return new ResponseEntity<>(messageService.updateMessage(id, message),HttpStatus.OK);
    }

}
