package com.br.ifspapi.comments;
import com.br.ifspapi.post.Post;
import com.br.ifspapi.user.User;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date = LocalDate.now();
    private String text;
    @ManyToOne
    private User user;

    public Comments(String text) {
        this.text = text;
    }

    public static Comments from(CommentsForm commentsForm) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return modelMapper.map(commentsForm, Comments.class);
    }

}
