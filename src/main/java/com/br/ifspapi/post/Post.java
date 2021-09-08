package com.br.ifspapi.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name ="post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String descricao;
    private LocalDateTime time = LocalDateTime.now();
    private Integer gpLike;
    private String postcol;

//    @ManyToOne
//    private Graduation graduation;
//    @ManyToOne
//    private Usuario usuario;

    public Post (String title, String teste) {
    }

    public static Post from(PostForm postForm){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(postForm, Post.class);
    };
}