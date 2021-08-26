package com.br.ifspapi.anexo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnexoForm {

    private String src;

    public static AnexoForm from(AnexoModel anexoModel){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(anexoModel, AnexoForm.class);
    }

}
