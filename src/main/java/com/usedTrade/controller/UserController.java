package com.usedTrade.controller;

import com.usedTrade.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/user")
public class UserController {
    @RequestMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User userById(@PathVariable("id") long id) {

    }

}
