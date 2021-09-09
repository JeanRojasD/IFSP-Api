package com.br.ifspapi.comments;

import com.br.ifspapi.user.User;
import com.br.ifspapi.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDTO {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;
    private String text;

    private UserDTO user;

    public static  CommentsDTO from(Comments comments){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return  modelMapper.map(comments, CommentsDTO.class);
    }

}
