package com.br.ifspapi.message.dto;

import com.br.ifspapi.message.model.Message;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDate;

public class MessageDTO {

    private Long id;
    @Getter @Setter
    private LocalDate dataCadastro;
    @Getter @Setter
    private String texto;


    public static MessageDTO from(Message message) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(message, MessageDTO.class);
    }
}