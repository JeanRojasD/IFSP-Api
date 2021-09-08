package com.br.ifspapi.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepositories extends JpaRepository<Post, Long> {

    Optional<Post> findByTitle (String teste);
}
