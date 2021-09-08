package com.br.ifspapi.test;

import com.br.ifspapi.post.PostForm;
import com.br.ifspapi.post.Post;
import com.br.ifspapi.post.PostRepositories;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PostTest {
    @Autowired
    private PostRepositories repositories;
    String teste = "projeto";

    @Test
    public void testSave () {

        PostForm postForm = new PostForm();
        postForm.setTitle("Teste");

        Post post = repositories.save(Post.from(postForm));
        assertEquals(post.getTitle(), postForm.getTitle());

    }

    @Test
    public void testUpdatePost () {

        Post post = new Post();
        repositories.save(post);

        Post post1 = repositories.findById(1L).get();
        post1.setTitle(teste);
        Post postUpdate = repositories.save(post1);

        assertEquals(postUpdate.getTitle(), teste);

    }

    @Test
    public void testDeleta () {

        //System.out.println("Carregando.....");
        Post post = new Post();
        post.setTitle(teste);
        repositories.save(post);

        Post post1 = repositories.findById(1L).get();

        repositories.delete(post1);

        Post post2 = null;

        Optional<Post> optionalPost = repositories.findByTitle("Teste");

        if (optionalPost.isPresent()) {
            post2 = optionalPost.get();
        }
        Assertions.assertThat(post2).isNull();
    }
}
