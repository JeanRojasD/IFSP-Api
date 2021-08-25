package com.br.ifspapi.graduation.dto;

import com.br.ifspapi.graduation.model.Graduation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class GraduationDto {

    private Long id;
    private String name;
    private String descricao;

    public static GraduationDto from(Graduation graduation) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(graduation, GraduationDto.class);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
