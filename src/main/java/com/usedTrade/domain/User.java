package com.usedTrade.domain;

import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by albertoh on 2018-05-01.
 */

@Entity
@Table(name="User")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull(message="name cannot be null")
    private String name;

    @NotNull(message="age is required")
    @Min(value=18, message="user needs to be at least 18")
    private Integer age;

    @NotNull(message="credit card information is required")
    private String creditCard;

    @Email
    private String email;

    //mmddYYYY
    @NotNull(message="date of birth required")
    private String dateOfBirth;

    @OneToMany(cascade=CascadeType.REMOVE)
    private List<Post> posts;

    public User(@NotNull(message = "name cannot be null") String name, @NotNull(message = "age is required")
    @Min(value = 18, message = "user needs to be at least 18") Integer age,
                @NotNull(message = "credit card information is required") String creditCard,
                @Email String email, String dateOfBirth, List<Post> posts) {
        this.name = name;
        this.age = age;
        this.creditCard = creditCard;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.posts = posts;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", creditCard='" + creditCard + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", posts=" + posts +
                '}';
    }
}
