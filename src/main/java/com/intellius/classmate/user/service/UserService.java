package com.intellius.classmate.user.service;

import com.intellius.classmate.user.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> getUser(Long id) throws Exception;

    User saveUser() throws Exception;

    List<User> allUserList() throws Exception;
}
