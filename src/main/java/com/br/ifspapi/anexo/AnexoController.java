package com.br.ifspapi.anexo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anexo")
public class AnexoController {

    private AnexoService anexoService;

    @Autowired
    AnexoController(AnexoService anexoService){this.anexoService = anexoService;}

    @GetMapping
    public ResponseEntity<List<AnexoDTO>> findAll(){return ResponseEntity.ok(anexoService.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<AnexoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(anexoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AnexoDTO> create(@RequestBody @Validated AnexoForm anexoForm){
        return ResponseEntity.ok(anexoService.save(anexoForm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnexoDTO> update(@PathVariable Long id, @RequestBody @Validated AnexoForm anexoForm){
        return ResponseEntity.ok(anexoService.update(id , anexoForm));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        anexoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
