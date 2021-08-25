package com.br.ifspapi.anexo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

import javax.persistence.*;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "anexo")
public class AnexoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    @Getter @Setter
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
