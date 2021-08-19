package com.br.ifspapi.comments.service;

import com.br.ifspapi.comments.dto.CommentsDTO;
import com.br.ifspapi.comments.form.CommentsForm;
import com.br.ifspapi.comments.model.Comments;
import com.br.ifspapi.comments.repository.CommentsRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CommentsService {

    private final Logger logger = LoggerFactory.getLogger(CommentsService.class);

    private final CommentsRepository commentsRepository;

    public CommentsService ( CommentsRepository commentsRepository ){

        this.commentsRepository = commentsRepository;

    }

    public Page<CommentsDTO> findAll(Pageable pageable) {
        Page<Comments> demandList = commentsRepository.findAll(pageable);
        return demandList.map(CommentsDTO::from);
    }

    public CommentsDTO findById(Long id){
        return CommentsDTO.from(commentsRepository.findById(id).orElseThrow(() -> {
            logger.error("Comments not found {}", id);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }));
    }

    public CommentsDTO Create  (CommentsForm commentsForm){

        Comments commentsCreate = Comments.from(commentsForm);

        return CommentsDTO.from(commentsRepository.save(commentsCreate));

    }

    public CommentsDTO update(CommentsForm commentsForm, Long id){

        var modelMapper = new ModelMapper();
        var commentsFound = commentsRepository.findById(id).orElseThrow(() -> {
            logger.error("Comment not found {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });

        modelMapper.map(commentsForm, commentsFound);

        return CommentsDTO.from(commentsRepository.save(commentsFound));
    }

    public void delete (Long id ){

        Comments comments = commentsRepository.findById(id).orElseThrow(() -> {
            logger.error("ID not Found");
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        });

        commentsRepository.delete(comments);
    }
}