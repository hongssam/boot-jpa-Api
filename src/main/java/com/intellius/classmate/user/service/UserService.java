package com.intellius.classmate.user.service;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.user.entity.User;

import java.util.List;


public interface UserService {
    ApiResponseMessage getUser(String id) throws Exception;

    ApiResponseMessage saveUser(User user) throws Exception;

    ApiResponseMessage allUserList() throws Exception;
}
