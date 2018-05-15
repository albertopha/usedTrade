package com.usedTrade.service;

import com.usedTrade.domain.User;
import com.usedTrade.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User userById(long id) {
        Optional<User> user = usersRepository.findById(id);

        if(!user.isPresent()) {
            return null;
        }

        return user.get();
    }

    public List<User> getUsersByFirstName(String firstName) {
        return usersRepository.findByFirstName(firstName);
    }

    public List<User> getUsersByLastName(String lastName) {
        return usersRepository.findByLastName(lastName);
    }

    public List<User> getUsersByFullName(String fullName) {
        String[] nameArray = fullName.split("_");
        String firstName,
                lastName;
        String middleName = "";

        List<User> usersWithFirstName;
        List<User> usersMatching = new ArrayList<User>();

        firstName = nameArray[0];

        if(nameArray.length == 2) {
            lastName = nameArray[1];
        } else {
            middleName = nameArray[1];
            lastName = nameArray[2];
        }

        usersWithFirstName = usersRepository.findByFirstName(firstName);

        for(User user: usersWithFirstName) {
            if(user.getLastName() == lastName) {
                if(user.getMiddleName() == middleName || middleName.length() == 0) {
                    usersMatching.add(user);
                }
            }
        }

        return usersMatching;

    }

    public List<User> getUsersByDateOfBirth(String dob) {
        if(dob.length() == 0 || dob.length() > 8) return null;
        return usersRepository.findByDateOfBirth(dob);
    }


}
