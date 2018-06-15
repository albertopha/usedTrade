package com.usedTrade.repository;

import com.usedTrade.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by albertoh on 2018-05-01.
 */

@Repository("userRepository")
public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String name);
    List<User> findByLastName(String name);
    List<User> findByDateOfBirth(String bd);
}
