package com.usedTrade.controller;

import com.usedTrade.domain.User;
import com.usedTrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;


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
    public List<User> getUsersByDateOfBirth(@RequestParam("dob") String dob) {
        return userService.getUsersByDateOfBirth(dob);
    }

    // POST user TODO: need logic for this post method, check if requestbody works properly
    /**
     *
     * @param firstName : String
     * @param lastName : String
     * @param middleName : String || ""
     * @param age : Integer
     * @param creditCard : String
     * @param email : String || ""
     * @param dob : String
     * @return ResponseEntity
     */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseEntity<User> postUser(@RequestBody String firstName, @RequestBody String lastName, @RequestBody(required=false) String middleName,
                                         @RequestBody Integer age, @RequestBody String creditCard, @RequestBody(required=false) String email,
                                         @RequestBody String dob) {

        User user = userService.postUser(firstName, lastName, middleName, age, creditCard, email, dob);
        return ResponseEntity.ok(user);
    }

    // PUT user TODO: need logic for put method

    /**
     *
     * @param firstName : String || ""
     * @param lastName : String || ""
     * @param middleName : String || ""
     * @param age : Integer || -1
     * @param creditCard : String
     * @param email : String || ""
     * @param dob : String || ""
     * @return ResponseEntity || NOT_FOUND
     */
    @RequestMapping(value="/{userId}", method=RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("userId") long userId,
                                           @RequestBody String firstName, @RequestBody String lastName, @RequestBody(required=false) String middleName,
                                           @RequestBody Integer age, @RequestBody String creditCard, @RequestBody(required=false) String email,
                                           @RequestBody String dob) {

        User user = userService.userById(userId);
        if(user == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        userService.updateUser(user,firstName, lastName, middleName, age, creditCard, email, dob);

        return ResponseEntity.ok(user);
    }

    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
    }
}
