package com.usedTrade.controller;

import com.usedTrade.domain.User;
import com.usedTrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET all users
    @RequestMapping(value="/", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    // GET user by id
    @RequestMapping(value="/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User userById(@PathVariable("id") long id) {
        return userService.userById(id);
    }

    // GET users by firstName
    @RequestMapping(value="/name", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByFirstName(@RequestParam("firstName") String firstName) {
        return userService.getUsersByFirstName(firstName);
    }

    // GET users by lastName
    @RequestMapping(value="/name", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByLastName(@RequestParam("lastName") String lastName) {
        return userService.getUsersByLastName(lastName);
    }

    // GET users by full name
    @RequestMapping(value="/name", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByFullName(@RequestParam("fullName") String fullName) {
        return userService.getUsersByFullName(fullName);
    }

    // GET users by date of birth
    @RequestMapping(value="/dob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByDateOfBirth(@PathVariable("dob") String dob) {
        return userService.getUsersByDateOfBirth(dob);
    }


}
