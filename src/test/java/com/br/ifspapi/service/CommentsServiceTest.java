package com.br.ifspapi.service;


import com.br.ifspapi.comments.CommentsForm;
import com.br.ifspapi.comments.Comments;
import com.br.ifspapi.comments.CommentsRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
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
    public void updateComentario(){

        Comments comments1 = commentsRepository.save(new Comments("text update"));

        CommentsForm commentsForm = new CommentsForm("text mudou");

        Comments comments = commentsRepository.getById(2L);

        var modelMapper = new ModelMapper();

        modelMapper.map(commentsForm, comments);

        commentsRepository.save(comments);


        assertEquals(commentsForm.getText(), comments.getText());

    }


    @Test
    @Rollback(false)
    public void deleteComentario(){
        commentsRepository.deleteById(1L);

        assertEquals(Optional.empty(), commentsRepository.findById(1L));

    }


}
