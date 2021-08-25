package com.br.ifspapi.graduation.model;

import com.br.ifspapi.graduation.dto.GraduationForm;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Graduation")
public class Graduation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;

    public Graduation(){

    }

    public Graduation(String name, String descricao) {
        this.name = name;
        this.descricao = descricao;
    }


    public static Graduation from(GraduationForm graduationForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(graduationForm, Graduation.class);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Graduation)) return false;
        Graduation graduation1 = (Graduation) o;
        return getId().equals(graduation1.getId()) && Objects.equals(getName(), graduation1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
