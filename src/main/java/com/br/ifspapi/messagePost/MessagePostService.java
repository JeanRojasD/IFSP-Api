package com.br.ifspapi.messagePost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessagePostService {

    private final Logger logger = LoggerFactory.getLogger(MessagePostService.class);

    private final MessagePostRepository messagePostRepository;

    public MessagePostService(MessagePostRepository messagePostRepository){this.messagePostRepository = messagePostRepository;}

    public List<MessagePostDTO> findAll(){
        List<MessagePostModel> messagePostModelList = messagePostRepository.findAll();
        return messagePostModelList.stream().map(MessagePostDTO::from).collect(Collectors.toList());
    }

    public MessagePostDTO findById(Long id){
        return MessagePostDTO.from(messagePostRepository.findById(id).orElseThrow(() -> {
            logger.error("Não foi encontrado", id);
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }));
    }

    public MessagePostDTO save(MessagePostForm messagePostForm){
        return MessagePostDTO.from(messagePostRepository.save(new MessagePostModel(messagePostForm.getDataEnvio(), messagePostForm.getTexto())));
    }

    public MessagePostDTO update(Long id,MessagePostForm messagePostForm) {
        MessagePostModel messagePostModel = messagePostRepository.findById(id).orElseThrow(() -> {
            logger.error("Esta Mensagem Não Foi Encontrada", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        messagePostModel.setDataEnvio(messagePostForm.getDataEnvio());
        messagePostModel.setTexto(messagePostForm.getTexto());
        return MessagePostDTO.from(messagePostRepository.save(messagePostModel));
    }

    public void delete(Long id){
        MessagePostModel messagePostModel = messagePostRepository.findById(id).orElseThrow(() -> {
            logger.error("O Id Não Foi Encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        messagePostRepository.delete(messagePostModel);
    }
}
