package com.usedTrade.domain;

import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by albertoh on 2018-05-01.
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotNull(message="name cannot be null")
    private String firstName;

    @NotNull (message="Last name cannot be null")
    private String lastName;

    private String middleName;

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

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy = "user")
    private List<Post> posts;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "user")
    private List<Comment> comments;

    protected User() {

    }

    public User(@NotNull(message = "name cannot be null") String firstName,
                @NotNull(message = "Last name cannot be null") String lastName,
                String middleName, @NotNull(message = "age is required")
                @Min(value = 18, message = "user needs to be at least 18") Integer age,
                @NotNull(message = "credit card information is required") String creditCard,
                @Email String email, @NotNull(message = "date of birth required") String dateOfBirth,
                List<Post> posts, List<Comment> comments) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.creditCard = creditCard;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.posts = posts;
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                ", creditCard='" + creditCard + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", posts=" + posts +
                ", comments=" + comments +
                '}';
    }
}
