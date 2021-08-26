package com.br.ifspapi.comments.controller;

import com.br.ifspapi.comments.dto.CommentsDTO;
import com.br.ifspapi.comments.form.CommentsForm;
import com.br.ifspapi.comments.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) { this.commentsService = commentsService;}

    @PostMapping
    public ResponseEntity<CommentsDTO> create (@RequestBody @Validated CommentsForm commentsForm){

        return ResponseEntity.ok(commentsService.Create(commentsForm));

    }

    @GetMapping
    public ResponseEntity<Page<CommentsDTO>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable pageable){
        return ResponseEntity.ok(commentsService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentsDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(commentsService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentsDTO> update(@PathVariable Long id, @RequestBody @Validated CommentsForm commentsForm){
        return  ResponseEntity.ok(commentsService.update(commentsForm, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        commentsService.delete(id);
        return ResponseEntity.ok().build();
    }

}
