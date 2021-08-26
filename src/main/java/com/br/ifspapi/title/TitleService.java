package com.br.ifspapi.title;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TitleService {

    @Autowired
    private TitleRepository titleRepository;

    Logger logger = LoggerFactory.getLogger(TitleService.class);

    public TitleService(TitleRepository titleRepository) {
        this.titleRepository = titleRepository;
    }

    public List<TitleDTO> findAll() {
        List<Title> titleList = titleRepository.findAll();
        return  titleList.stream().map(TitleDTO::from).collect(Collectors.toList());
    }

    public TitleDTO create(TitleForm titleForm){
        if (titleRepository.findByTitleContaining(titleForm.getTitle()).isPresent()) {
            logger.error("Title already exists {}", titleForm.getTitle());
        }

        return TitleDTO.from(titleRepository.save(Title.from(titleForm)));
    }

    public TitleDTO update(Long id, TitleForm titleForm){
        Title title = titleRepository.findById(id).orElseThrow(()->{
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        var modelMapper = new ModelMapper();
        var titleFound = titleRepository.findById(id).orElseThrow(()->{
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(titleForm, titleFound);

        return TitleDTO.from(titleRepository.save(titleFound));
    }

    public void delete(Long id){
        Title title = titleRepository.findById(id).orElseThrow(()->{
            logger.error("Id not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        titleRepository.delete(title);
    }
}
