package com.br.ifspapi.anexo;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "anexo")
@Getter @Setter
public class AnexoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String src;

    public AnexoModel(String src) {
        this.src = src;
    }

    public static AnexoModel from(AnexoForm anexoForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(anexoForm, AnexoModel.class);
    }
}
