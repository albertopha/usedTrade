package com.usedTrade.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min=0)
    @Length(max=1000)
    private String text;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_post")
    @JsonIgnore
    private Post post;

    protected Comment(){}

    public Comment(@Min(value = 0) @Max(value = 1000) String text, User user, Post post) {
        this.text = text;
        this.user = user;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", post=" + post +
                '}';
    }
}
