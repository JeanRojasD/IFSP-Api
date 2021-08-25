package com.br.ifspapi.graduation.repository;

import com.br.ifspapi.graduation.model.Graduation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GraduationRepository extends JpaRepository<Graduation, Long> {

    public Graduation findByName(String name);

    Optional<Graduation> findByNameContaining(String name);
}
