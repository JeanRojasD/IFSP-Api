package com.br.ifspapi.graduation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/graduation")
public class GraduationController {

    private final GraduationService graduationService;

    @Autowired
    public GraduationController(GraduationService graduationService) {
        this.graduationService = graduationService;
    }

    @GetMapping
    public ResponseEntity<Page<GraduationDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(graduationService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GraduationDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(graduationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<GraduationDto> create (@RequestBody @Validated GraduationForm graduationForm){
        return ResponseEntity.ok(graduationService.save(graduationForm));
    }
    @PutMapping("/{id}")
    public ResponseEntity<GraduationDto> update(@PathVariable Long id, @Validated @RequestBody GraduationForm graduationForm) {
        return ResponseEntity.ok(graduationService.update(graduationForm, id));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        graduationService.delete(id);
    }
}
