package com.intellius.classmate.user.service;

import com.intellius.classmate.apiResponse.Message;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity<Message> getUserList(Long id) throws Exception;

    ResponseEntity<Message> saveUser();

    ResponseEntity<Message> allUserList();
}
