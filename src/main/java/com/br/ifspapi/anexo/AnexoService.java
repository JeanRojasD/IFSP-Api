package com.br.ifspapi.anexo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnexoService {

    private final Logger logger = LoggerFactory.getLogger(AnexoService.class);

    @Autowired
    private final AnexoRepository anexoRepository;

    public AnexoService(AnexoRepository anexoRepository){this.anexoRepository = anexoRepository;}

    public List<AnexoDTO> findAll(){
        List<AnexoModel> anexoModelList = anexoRepository.findAll();
        return anexoModelList.stream().map(AnexoDTO::from).collect(Collectors.toList());
    }

    public AnexoDTO findById(Long id){
        return AnexoDTO.from(anexoRepository.findById(id).orElseThrow(() -> {
            logger.error("Id Not Found", id);
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }));
    }

    public AnexoDTO save(AnexoForm anexoForm){
        return AnexoDTO.from(anexoRepository.save(new AnexoModel(anexoForm.getSrc())));
    }

    public AnexoDTO update(Long id, AnexoForm anexoForm){
        AnexoModel anexoModel = anexoRepository.findById(id).orElseThrow(() -> {
            logger.error("Anexo não encontrado", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        anexoModel.setSrc(anexoForm.getSrc());
        return AnexoDTO.from(anexoRepository.save(anexoModel));
    }

    public void delete(Long id){
        AnexoModel anexoModel = anexoRepository.findById(id).orElseThrow(() -> {
            logger.error("Id não foi encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        anexoRepository.delete(anexoModel);
    }



}
