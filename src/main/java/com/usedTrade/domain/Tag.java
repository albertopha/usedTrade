package com.usedTrade.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "must enter name of the tag")
    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    @JsonIgnore
    private Post post;

    protected Tag() {

    }

    public Tag(@NotNull(message = "must enter name of the tag") String name, Post post) {
        this.name = name;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
