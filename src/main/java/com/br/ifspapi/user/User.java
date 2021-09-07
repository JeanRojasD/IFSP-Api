package com.br.ifspapi.user;

import com.br.ifspapi.commons.Affiliation;
import com.br.ifspapi.commons.Roles;
import com.br.ifspapi.graduation.Graduation;
import com.br.ifspapi.title.Title;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imgUser;
    private String name;
    private String userName;
    private String email;
    private LocalDate birth;
    private Integer ra;
    private LocalDate dataInit;
    private LocalDate dataEnd;
    @CollectionTable(joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Roles role;
    @Enumerated(EnumType.STRING)
    @Column(name = "affiliation")
    private Affiliation affiliation;
    @ManyToOne
    private Graduation graduation;
    @ManyToOne
    private Title title;



}
