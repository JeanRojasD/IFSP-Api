package com.br.ifspapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name ="PostModel")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPost;
    private String title;
    private String descricao;
    private Date time;
    private int gpLike;
    private String postcol;

    public PostModel () {
    }

    public PostModel (long idPost, String title, String descricao, Date time, int gpLike, String postcol) {
        this.idPost = idPost;
        this.title = title;
        this.descricao = descricao;
        this.time = time;
        this.gpLike = gpLike;
        this.postcol = postcol;
    }

    public long getIdPost () {
        return idPost;
    }

    public void setIdPost (long idPost) {
        this.idPost = idPost;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getDescricao () {
        return descricao;
    }

    public void setDescricao (String descricao) {
        this.descricao = descricao;
    }

    public Date getTime () {
        return time;
    }

    public void setTime (Date time) {
        this.time = time;
    }

    public int getGpLike () {
        return gpLike;
    }

    public void setGpLike (int gpLike) {
        this.gpLike = gpLike;
    }

    public String getPostcol () {
        return postcol;
    }

    public void setPostcol (String postcol) {
        this.postcol = postcol;
    }

    @Override
    public String toString () {
        return "PostModel{" +
                "idPost=" + idPost +
                ", title='" + title + '\'' +
                ", descricao='" + descricao + '\'' +
                ", time=" + time +
                ", gpLike=" + gpLike +
                ", postcol='" + postcol + '\'' +
                '}';
    }
}
