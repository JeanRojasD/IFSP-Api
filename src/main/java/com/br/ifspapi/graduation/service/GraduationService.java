package com.br.ifspapi.graduation.service;

import com.br.ifspapi.graduation.dto.GraduationDto;
import com.br.ifspapi.graduation.dto.GraduationForm;
import com.br.ifspapi.graduation.model.Graduation;
import com.br.ifspapi.graduation.repository.GraduationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GraduationService {

    private static final String ID_NOT_FOUND = "ID não encontrado";
    private static final String ID_CONFLICT = "ID doesn´t match";
    private final Logger logger = LoggerFactory.getLogger(GraduationService.class);

    private final GraduationRepository graduationRepository;

    public GraduationService(GraduationRepository graduationRepository) {
        this.graduationRepository = graduationRepository;
    }

    public Page<GraduationDto> findAll(Pageable pageable) {
        Page<Graduation> graduationList = graduationRepository.findAll(pageable);
        return graduationList.map(GraduationDto::from);
    }

    public GraduationDto findById(Long id){
        return GraduationDto.from(graduationRepository.findById(id).orElseThrow(() -> {
            logger.error("Graduation not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        }));
    }

    public GraduationDto save(GraduationForm graduationForm){
        if (graduationRepository.findByNameContaining(graduationForm.getName()).isPresent()) {
            logger.error("Graduation already exists {}", graduationForm.getName());
        }
        return GraduationDto.from(graduationRepository.save(new Graduation(graduationForm.getName(), graduationForm.getDescricao())));
    }

    public GraduationDto update(GraduationForm graduationForm, Long id) {
        Graduation graduation = graduationRepository.findById(id).orElseThrow(() -> {
            logger.error("Graduation not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        });
        if (!graduation.getId().equals(id)) {
            logger.error("ID Graduation conflict {}", id);
            throw new ResponseStatusException(HttpStatus.CONFLICT, ID_CONFLICT);
        }
        graduation.setName(graduationForm.getName());
        graduation.setDescricao(graduationForm.getDescricao());

        return GraduationDto.from(graduationRepository.save(graduation));
    }
    public void delete(Long id) {
        Graduation graduation = graduationRepository.findById(id).orElseThrow(() -> {
            logger.error("ID not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ID_NOT_FOUND);
        });
        graduationRepository.delete(graduation);
    }


}
