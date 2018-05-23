package com.usedTrade.service;

import com.usedTrade.domain.Post;
import com.usedTrade.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts;
    }

    public Post getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        return post.get();
    }


}
