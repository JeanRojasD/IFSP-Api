package com.br.ifspapi.service;

import com.br.ifspapi.dto.PostDto;
import com.br.ifspapi.dto.form.PostForm;
import com.br.ifspapi.model.Post;
import com.br.ifspapi.repositories.PostRepositories;
import com.br.ifspapi.service.exceptions.DataIntegrityViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepositories repositories;

    public List<PostDto> findAll () {
        List<Post> result = repositories.findAll();
        return result.stream().map(PostDto::from).collect(Collectors.toList());
    }

    public PostDto create (PostForm obj) {
        Post post = Post.from(obj);
        return PostDto.from(repositories.save(post));
    }

    public PostDto findById (Long id) {
        Optional<Post> obj = repositories.findById(id);
        return PostDto.from(obj.get());
    }

    public PostDto update (Long id, PostForm post) {
        ModelMapper modelMapper = new ModelMapper();
        Post post1 = repositories.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        });
        modelMapper.map(post, post1);
        return PostDto.from(repositories.save(post1));
    }

    public void delete (long idPost) {
        findById(idPost);
        try {
            repositories.deleteById(idPost);

        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Objeto não pode ser deletado!!!");
        }

    }

}
