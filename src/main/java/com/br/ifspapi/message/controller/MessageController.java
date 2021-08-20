package com.br.ifspapi.message.controller;

import com.br.ifspapi.message.dto.MessageDTO;
import com.br.ifspapi.message.dto.MessageForm;
import com.br.ifspapi.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService){this.messageService = messageService;}

    @GetMapping
    public ResponseEntity<List<MessageDTO>> findAll(){return ResponseEntity.ok(messageService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(messageService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MessageDTO> create(@RequestBody @Validated MessageForm messageForm){
        return ResponseEntity.ok(messageService.save(messageForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDTO> update(@PathVariable Long id,@RequestBody @Validated MessageForm messageForm){
        return ResponseEntity.ok(messageService.update(id,messageForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
     messageService.delete(id);
     return ResponseEntity.ok().build();
    }
}
