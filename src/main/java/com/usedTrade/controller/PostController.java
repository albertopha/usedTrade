package com.usedTrade.controller;

import com.usedTrade.domain.Item;
import com.usedTrade.domain.Post;
import com.usedTrade.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable("postId") Long postId) {
        return postService.getPostById(postId);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Post> createPost(String title, String postedDate, String content, Item item, @PathVariable("userId") Long userId) {

    }
}
