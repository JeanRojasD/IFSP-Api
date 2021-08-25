package com.br.ifspapi.graduation.dto;


import com.br.ifspapi.graduation.model.Graduation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GraduationForm {

    @NotNull
    @NotBlank
    private String name;
    private String descricao;

    public GraduationForm(){

    }

    public GraduationForm(String name, String descricao) {
        this.name = name;
        this.descricao = descricao;
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
