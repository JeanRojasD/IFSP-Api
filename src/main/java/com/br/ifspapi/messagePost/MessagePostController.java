package com.br.ifspapi.messagePost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messagepost")
public class MessagePostController {

    private final MessagePostService messagePostService;

    @Autowired
    public MessagePostController(MessagePostService messagePostService){this.messagePostService = messagePostService;}

    @GetMapping
    public ResponseEntity<List<MessagePostDTO>> findAll(){return ResponseEntity.ok(messagePostService.findAll());}

    @GetMapping("find/{id}")
    public ResponseEntity<MessagePostDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(messagePostService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MessagePostDTO> create(@RequestBody @Validated MessagePostForm messagePostForm){
       return ResponseEntity.ok(messagePostService.save(messagePostForm));
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<MessagePostDTO> update(@PathVariable Long id, @RequestBody @Validated MessagePostForm messagePostForm){
        return ResponseEntity.ok(messagePostService.update(id,messagePostForm));
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        messagePostService.delete(id);
        return ResponseEntity.ok().build();
    }
}
