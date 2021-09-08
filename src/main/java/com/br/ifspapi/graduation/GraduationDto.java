package com.br.ifspapi.graduation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraduationDto {

    private Long id;
    private String name;
    private String descricao;

    public static GraduationDto from(Graduation graduation) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(graduation, GraduationDto.class);
    }

}
