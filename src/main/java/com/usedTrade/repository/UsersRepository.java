package com.usedTrade.repository;

import com.usedTrade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by albertoh on 2018-05-01.
 */

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
    public User findByName(String name);
    public User findByBirthDate(String bd);
}
