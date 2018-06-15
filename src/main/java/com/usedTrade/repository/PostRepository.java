package com.usedTrade.repository;

import com.usedTrade.domain.Post;
import com.usedTrade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Long> {
//    List<Post> getPostsByUser(User user);

    List<Post> getPostsByUser_Id(Long userId);

    // Alternative: TODO: test this
    // @Query("SELECT POST AS p WHERE p.user.id = :userId
    // List<Post> getPostsByUserId(@Param("userId") Long userId);
}
