package com.usedTrade.repository;

import com.usedTrade.domain.Post;
import com.usedTrade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> getPostsByUser_Id(Long userId);
    List<Post> getPostsByTag_Id(Long tagId);
}
