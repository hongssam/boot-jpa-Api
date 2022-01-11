package com.intellius.classmate.user.service;

import com.intellius.classmate.apiResponse.Message;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity<Message> getUserList(Long id);

    ResponseEntity<Message> saveUser();

    ResponseEntity<Message> allUserList();
}
