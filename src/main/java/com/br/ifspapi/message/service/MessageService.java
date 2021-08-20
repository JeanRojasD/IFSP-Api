package com.br.ifspapi.message.service;
import com.br.ifspapi.message.dto.MessageDTO;
import com.br.ifspapi.message.dto.MessageForm;
import com.br.ifspapi.message.model.Message;
import com.br.ifspapi.message.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<MessageDTO> findAll() {
        List<Message> messageList = messageRepository.findAll();
        return messageList.stream().map(MessageDTO::from).collect(Collectors.toList());
    }

    public MessageDTO findById(Long id){
        return MessageDTO.from(messageRepository.findById(id).orElseThrow(() -> {
        logger.error("Não encontrado", id);
        throw new ResponseStatusException(HttpStatus.CONFLICT);
        }));
    }

    public MessageDTO save(MessageForm messsageForm){
        return MessageDTO.from(messageRepository.save(new Message(messsageForm.getDataCadastro(), messsageForm.getTexto())));
    }

    public MessageDTO update(Long id,MessageForm messageForm) {
        Message message = messageRepository.findById(id).orElseThrow(() -> {
            logger.error("Mensagem não encontrada", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        message.setDataCadastro(messageForm.getDataCadastro());
        message.setTexto(messageForm.getTexto());
        return MessageDTO.from(messageRepository.save(message));
    }

    public void delete(Long id){
        Message message = messageRepository.findById(id).orElseThrow(() -> {
            logger.error("Id Não Encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        messageRepository.delete(message);
    }

}
