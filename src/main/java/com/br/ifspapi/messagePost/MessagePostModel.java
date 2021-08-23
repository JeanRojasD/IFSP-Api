package com.br.ifspapi.messagePost;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "messagepost")
@Entity
@NoArgsConstructor
@EqualsAndHashCode
public class MessagePostModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Getter @Setter
        private Long id;
        @Getter @Setter
        private LocalDate dataEnvio;
        @Getter @Setter
        private String texto;

    public MessagePostModel(LocalDate dataEnvio, String texto) {
        this.dataEnvio = dataEnvio;
        this.texto = texto;
    }

    public static MessagePostModel from(MessagePostForm messageForm){
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            return modelMapper.map(messageForm, MessagePostModel.class);
        }
    }