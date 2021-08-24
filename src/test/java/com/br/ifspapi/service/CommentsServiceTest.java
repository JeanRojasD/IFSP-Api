package com.br.ifspapi.service;


import com.br.ifspapi.comments.controller.CommentsController;
import com.br.ifspapi.comments.dto.CommentsDTO;
import com.br.ifspapi.comments.form.CommentsForm;
import com.br.ifspapi.comments.model.Comments;
import com.br.ifspapi.comments.repository.CommentsRepository;
import com.br.ifspapi.comments.service.CommentsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CommentsServiceTest {


    @Autowired
    private CommentsRepository commentsRepository;

    @Test
    @Rollback(false)
    public void verificarCometarioCriado( ){
        CommentsForm commentsForm = new CommentsForm( "oi");
        Comments comments1 = commentsRepository.save(Comments.from(commentsForm));

        assertEquals(comments1.getText(), commentsForm.getText());
        
    }

    @Test
    @Rollback(false)
    public void listarComentarioCriado(){
        CommentsForm commentsForm = new CommentsForm( "text listagem");
        Comments comments1 = commentsRepository.save(Comments.from(commentsForm));
        String text = "text listagem" ;

        Comments comments = commentsRepository.findByText(text);

        assertEquals(comments.getText(), text );

    }

    @Test
    @Rollback(false)
    public void deleteComentario(){
        commentsRepository.deleteById(1L);

        assertEquals(Optional.empty(), commentsRepository.findById(1L));

    }


}
