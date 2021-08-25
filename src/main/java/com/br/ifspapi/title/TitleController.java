package com.br.ifspapi.title;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    public TitleController(TitleService titleService) {
        this.titleService = titleService;
    }

    @GetMapping
    public ResponseEntity<List<TitleDTO>> findAll(){
        return ResponseEntity.ok(titleService.findAll());
    }

    @PostMapping
    public ResponseEntity<TitleDTO> create(@RequestBody @Validated TitleForm titleForm){
        return ResponseEntity.ok(titleService.create(titleForm));
    }

    @PutMapping
    public ResponseEntity<TitleDTO> update(@PathVariable Long id, @RequestBody @Validated TitleForm titleForm){
        return ResponseEntity.ok(titleService.update(id, titleForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        titleService.delete(id);
        return ResponseEntity.ok().build();
    }


}
