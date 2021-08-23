package com.br.ifspapi.messagePost;


import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import java.time.LocalDate;

@Getter @Setter
public class MessagePostDTO {

    private Long id;
    private LocalDate dataEnvio;
    private String texto;

    public static MessagePostDTO from(MessagePostModel message) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(message, MessagePostDTO.class);
    }
}
