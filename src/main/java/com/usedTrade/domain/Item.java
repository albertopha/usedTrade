package com.usedTrade.domain;

import javax.persistence.*;
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

    @OneToOne()
    private User user;

    public Item(@NotNull(message = "name of the item is required") String name, Integer price, User user) {
        this.name = name;
        this.price = price;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
