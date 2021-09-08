package com.br.ifspapi.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostForm {

    private String title;
    private String descricao;
    private Integer gpLike;
    private String postcol;

}
