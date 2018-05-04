package com.usedTrade.repository;

import com.usedTrade.domain.Comment;
import com.usedTrade.domain.Post;
import com.usedTrade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    public List<Comment> getCommentByPost(Post post); //TODO: will this work with post object parameter? Or implement with postId?

    public List<Comment> getCommentByUser(User user); //TODO: will this work?
}
