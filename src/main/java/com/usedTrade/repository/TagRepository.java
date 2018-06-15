package com.usedTrade.repository;

import com.usedTrade.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("tagRepository")
public interface TagRepository extends JpaRepository<Tag, Long> {
}
