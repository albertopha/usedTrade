package com.usedTrade.repository;

import com.usedTrade.domain.Item;
import com.usedTrade.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> getItemsByPost_Id(Long postId);
}
