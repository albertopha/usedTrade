package com.usedTrade.controller;

import com.usedTrade.domain.Comment;
import com.usedTrade.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/comment")
public class CommentController {

    @Autowired
    @Qualifier("commentService")
    private CommentService commentService;

    @GetMapping("/")
    public List<Comment> getAllComments() {
        return commentService.getAllComments();
    }

    // GET comment by commentId
    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable("commentId") Long commentId) {
        return commentService.getCommentById(commentId);
    }

    // GET comments from postId
    @GetMapping("/post/{postId}")
    public List<Comment> getCommentsByPost(@PathVariable("postId") long postId) {
        return commentService.getCommentsByPost(postId);
    }

    // GET comments from userId
    @GetMapping("/user/{userId}")
    public List<Comment> getCommentsByUser(@PathVariable("userId") long userId) {
        return commentService.getCommentsByUser(userId);
    }

    @PostMapping("/")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment,
                                                 @RequestParam("postId") Long postId,
                                                 @RequestParam("userId") Long userId) {
        Comment newComment = commentService.createComment(comment, postId, userId);
        return ResponseEntity.ok(newComment);
    }

    @PutMapping("/")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable("commentId") Long commentId) {
        commentService.deleteComment(commentId);
    }
}
