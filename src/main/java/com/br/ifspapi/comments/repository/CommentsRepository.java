package com.br.ifspapi.comments.repository;

import com.br.ifspapi.comments.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Comments findByText(String text);

    Optional<Comments> findByTextContaining(String text);
}
