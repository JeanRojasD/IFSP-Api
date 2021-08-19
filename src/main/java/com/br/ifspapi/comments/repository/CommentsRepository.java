package com.br.ifspapi.comments.repository;

import com.br.ifspapi.comments.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
}
