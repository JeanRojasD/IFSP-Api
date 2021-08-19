package com.br.ifspapi.comments.form;

import com.br.ifspapi.comments.dto.CommentsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsForm {

    public CommentsDTO update;
    private LocalDateTime date;
    private String text;

}
