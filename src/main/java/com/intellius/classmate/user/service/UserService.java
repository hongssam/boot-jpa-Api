package com.intellius.classmate.user.service;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.user.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    ApiResponseMessage saveUser(User user);

    List<User> allUserList();

    User getUser(String id);
}
