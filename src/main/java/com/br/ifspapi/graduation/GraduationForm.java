package com.br.ifspapi.graduation;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraduationForm {

    @NotNull
    @NotBlank
    private String name;
    private String descricao;


}
