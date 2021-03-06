package com.usedTrade.controller;

import com.usedTrade.domain.User;
import com.usedTrade.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    @Qualifier("userService")
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
    @RequestMapping(value="/fname", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByFirstName(@RequestParam("firstName") String firstName) {
        return userService.getUsersByFirstName(firstName);
    }

    // GET users by lastName
    @RequestMapping(value="/lname", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByLastName(@RequestParam("lastName") String lastName) {
        return userService.getUsersByLastName(lastName);
    }

    // GET users by full name
    @RequestMapping(value="/fullname", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByFullName(@RequestParam("fullName") String fullName) {
        return userService.getUsersByFullName(fullName);
    }

    // GET users by date of birth
    @RequestMapping(value="/dob", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getUsersByDateOfBirth(@RequestParam("dob") String dob) {
        return userService.getUsersByDateOfBirth(dob);
    }

    // GET user by post id
    @RequestMapping(value="/post/{postId}", method=RequestMethod.GET)
    public User findUserByPostId(@PathVariable("postId") long postId) {
        return userService.findUserUsingPostId(postId);
    }

    // GET user by comment id
    @RequestMapping(value="/comment/{commentId}", method=RequestMethod.GET)
    public User findUserByCommentId(@PathVariable("commentId") long commentId) {
        return userService.findUserUsingCommentId(commentId);
    }

    /**
     * POST User
     * @return ResponseEntity
     */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    public ResponseEntity<User> postUser(@Valid @RequestBody User user) {

        User newUser = userService.postUser(user);
        return ResponseEntity.ok(newUser);
    }

    /**
     *
     * @param updatedUser
     * @return
     */
    @RequestMapping(value="/", method=RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser){
        User user = userService.updateUser(updatedUser);
        return ResponseEntity.ok(user);
    }

    // DELETE user by id
    @RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
    public void delete(@PathVariable("userId") long userId) {
        userService.deleteUser(userId);
    }

}
