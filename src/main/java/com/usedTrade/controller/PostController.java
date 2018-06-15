package com.usedTrade.controller;

import com.usedTrade.domain.Post;
import com.usedTrade.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/posts")
public class PostController {

    @Autowired
    @Qualifier("postService")
    private PostService postService;

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable("postId") Long postId) {
        return postService.getPostById(postId);
    }

    @GetMapping("/posts/{userId}")
    public List<Post> getPostsByUser(@PathVariable("userId") Long userId) {
        return postService.getPostsByUser(userId);
    }

    /**
     * @param newPost
     * @param userId
     * @return
     */
    @PostMapping(value = "/{userId}")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post newPost,
                                           @PathVariable("userId") Long userId) {
        Post post = postService.createPost(newPost, userId);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/")
    public ResponseEntity<Post> updatePost(Post postToUpdate) {
        Post post = postService.updatePost( postToUpdate);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);
    }

}
