package com.usedTrade.service;

import com.usedTrade.domain.Comment;
import com.usedTrade.domain.Post;
import com.usedTrade.domain.User;
import com.usedTrade.repository.CommentRepository;
import com.usedTrade.repository.PostRepository;
import com.usedTrade.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("commentService")
public class CommentService {

    @Autowired
    @Qualifier("commentRepository")
    private CommentRepository commentRepository;
    @Autowired
    @Qualifier("postRepository")
    private PostRepository postRepository;
    @Autowired
    @Qualifier("userRepository")
    private UsersRepository usersRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentbyId(Long commentId) {
        return commentRepository.findById(commentId).get();
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

    public Comment createComment(Comment comment, Long postId, Long userId) {
        Post post = postRepository.findById(postId).get();
        User user = usersRepository.findById(userId).get();

        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();
        commentRepository.delete(comment);
    }

}
