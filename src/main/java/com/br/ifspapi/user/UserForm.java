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
public class UserForm {

    private String imgUser;
    private String name;
    private String userName;
    private String cpf;
    private String email;
    private LocalDate birth;
    private Integer ra;
    private LocalDate dataInit;
    private LocalDate dataEnd;
    private Roles role;
    private Affiliation affiliation;
    private GraduationDto graduation;
    private TitleDTO title;

    public UserForm(String imgUser, String name, String userName, String email, LocalDate birth, Integer ra, LocalDate dataInit, LocalDate dataEnd, Roles role, Affiliation affiliation) {
        this.imgUser = imgUser;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.birth = birth;
        this.ra = ra;
        this.dataInit = dataInit;
        this.dataEnd = dataEnd;
        this.role = role;
        this.affiliation = affiliation;
    }
}
