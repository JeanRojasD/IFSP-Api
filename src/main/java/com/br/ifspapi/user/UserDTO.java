package com.br.ifspapi.user;

import com.br.ifspapi.commons.Affiliation;
import com.br.ifspapi.commons.Roles;
import com.br.ifspapi.graduation.Graduation;
import com.br.ifspapi.graduation.GraduationDto;
import com.br.ifspapi.title.Title;
import com.br.ifspapi.title.TitleDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String imgUser;
    private String name;
    private String userName;
    private String email;
    private LocalDate birth;
    private Integer ra;
    private LocalDate dataInit;
    private LocalDate dataEnd;
    private Roles role;
    private Affiliation affiliation;
    private GraduationDto graduation;
    private TitleDTO title;

}
