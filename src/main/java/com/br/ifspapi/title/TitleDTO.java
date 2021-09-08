package com.br.ifspapi.title;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TitleDTO {

    private Long id;
    private String title;

    public static TitleDTO from(Title title) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(title, TitleDTO.class);
    }
}
