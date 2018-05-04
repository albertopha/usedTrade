package com.usedTrade.controller;

import com.usedTrade.domain.Comment;
import com.usedTrade.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value="/", method=RequestMethod.GET)
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // GET comments from postId
    @RequestMapping(value="/post", method=RequestMethod.GET)
    public List<Comment> getCommentsByPost(@RequestParam("postId") long postId) {
        return commentService.getCommentsByPost(postId);
    }

    // GET comments from userId
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public List<Comment> getCommentsByUser(@RequestParam("userId") long userId) {
        return commentService.getCommentsByUser(userId);
    }

}
