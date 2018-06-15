package com.usedTrade.service;

import com.usedTrade.domain.Post;
import com.usedTrade.domain.User;
import com.usedTrade.repository.PostRepository;
import com.usedTrade.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("postService")
public class PostService {
    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;

    @Autowired
    @Qualifier("userRepository")
    private UsersRepository usersRepository;

    public List<Post> getAllPosts() {
        List<Post> allPosts = postRepository.findAll();
        return allPosts;
    }

    public Post getPostById(Long postId) {
        Optional<Post> post = postRepository.findById(postId);

        return post.get();
    }

    //TODO: see if this works
    public List<Post> getPostsByUser(Long userId) {
//        User user = usersRepository.findById(userId).get();
        return postRepository.getPostsByUser_Id(userId);
    }

    public Post createPost(Post newPost, Long userId) {
        User user = usersRepository.findById(userId).get();
        newPost.setUser(user);

        //TODO: check if this is necessary
//        List<Post> userPosts = user.getPosts();
//        userPosts.add(newPost);
//        user.setPosts(userPosts);
//
//        usersRepository.save(user);
        return postRepository.save(newPost);
    }

    public Post updatePost(Post postToUpdate) {
        return postRepository.save(postToUpdate);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
