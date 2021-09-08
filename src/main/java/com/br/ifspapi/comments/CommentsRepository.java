package com.br.ifspapi.comments;

import com.br.ifspapi.comments.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments, Long> {
    Comments findByText(String text);

    Optional<Comments> findByTextContaining(String text);
}
