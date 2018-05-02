package com.usedTrade.repository;

import com.usedTrade.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by albertoh on 2018-05-01.
 */
public interface UsersRepository extends CrudRepository<User, Long>{
}
