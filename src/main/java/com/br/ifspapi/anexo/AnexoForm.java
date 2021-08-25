package com.br.ifspapi.anexo;

import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class AnexoForm {

    private Long id;
    @Getter @Setter
    private String src;

    public static AnexoForm from(AnexoModel anexoModel){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(anexoModel, AnexoForm.class);
    }

}
