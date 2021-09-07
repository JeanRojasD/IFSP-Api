package com.br.ifspapi.controller;

import com.br.ifspapi.dto.PostDto;
import com.br.ifspapi.dto.form.PostForm;
import com.br.ifspapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById (@PathVariable Long idPost) {
        PostDto post = service.findById(idPost);
        return ResponseEntity.ok().body(post);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> findAll () {
        List<PostDto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<PostDto> create (@RequestBody PostForm obj) {
        return ResponseEntity.ok(service.create(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> update (@PathVariable Long id, @RequestBody PostForm obj) {

        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
