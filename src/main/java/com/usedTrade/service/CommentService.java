package com.usedTrade.service;

import com.usedTrade.domain.Comment;
import com.usedTrade.domain.Post;
import com.usedTrade.domain.User;
import com.usedTrade.repository.CommentRepository;
import com.usedTrade.repository.PostRepository;
import com.usedTrade.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UsersRepository usersRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    //TODO: Check if this works
    public List<Comment> getCommentsByPost(long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return commentRepository.getCommentByPost(post.get());
    }

    public List<Comment> getCommentsByUser(long userId) {
        Optional<User> user = usersRepository.findById(userId);
        return commentRepository.getCommentByUser(user.get());
    }

}
