package com.br.ifspapi.messagePost;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.time.LocalDate;

@Getter @Setter
public class MessagePostForm {

    @NotNull
    private LocalDate dataEnvio;
    private String texto;

    public static MessagePostForm from(MessagePostModel message) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(message, MessagePostForm.class);
    }
}
