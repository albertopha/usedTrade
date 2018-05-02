package com.usedTrade.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
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

    @Column (length = 100)
    private String name;

    @Column
    private Integer age;

    @Column (length = 20)
    private String creditCard;

//    @OneToMany(cascade = )
    private List<Post> posts;

}
