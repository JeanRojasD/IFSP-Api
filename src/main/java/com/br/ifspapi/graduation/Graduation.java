package com.br.ifspapi.graduation;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Graduation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Graduation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String descricao;

    public Graduation(String name, String descricao) {
        this.name = name;
        this.descricao = descricao;
    }

    public static Graduation from(GraduationForm graduationForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(graduationForm, Graduation.class);
    }

}
