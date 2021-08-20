package com.br.ifspapi.message.model;

import javax.persistence.*;

import java.time.LocalDate;

import com.br.ifspapi.message.dto.MessageForm;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Table(name = "Message")
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter @Setter private LocalDate dataCadastro;
    @Getter @Setter private String texto;

    public Message(LocalDate dataCadastro, String texto) {
        this.dataCadastro = dataCadastro;
        this.texto = texto;
    }

    public static Message from(MessageForm messageForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(messageForm, Message.class);
    }
}
