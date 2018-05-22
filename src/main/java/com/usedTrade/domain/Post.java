package com.usedTrade.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import com.usedTrade.domain.Tag;

/**
 * Created by albertoh on 2018-05-01.
 */

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message="post should have title")
    private String title;

    @NotNull(message="post should contain date")
    private String postedDate;

    @OneToMany (mappedBy = "fk_post")
    private List<Tag> tags;

    @OneToOne
    private Item item;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "fk_post")
    private List<Comment> comments;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user")
    private User user;

    protected Post() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(String postedDate) {
        this.postedDate = postedDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
