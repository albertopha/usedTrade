package com.usedTrade.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by albertoh on 2018-05-01.
 */

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message="name of the item is required")
    private String name;

    private Integer price;

    @Column(nullable = false, columnDefinition = "int default 0")
    private Integer quantity;

    @NotNull(message="image is required")
    private String imgUrl;

    @OneToOne
    private Post post;

    protected Item() {

    }

    public Item(@NotNull(message = "name of the item is required") String name, Integer price, Integer quantity, @NotNull(message = "image is required") String imgUrl, Post post) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", imgUrl='" + imgUrl + '\'' +
                ", post=" + post +
                '}';
    }
}
