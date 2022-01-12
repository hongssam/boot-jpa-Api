package com.intellius.classmate.user.controller;

import com.intellius.classmate.apiResponse.Message;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/list/{id}")
    public ResponseEntity<Message> getUserList(@PathVariable Long id) throws Exception {

        return userService.getUserList(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public ResponseEntity<Message> saveUser(){

        return userService.saveUser();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<Message> allUserList(){

        return userService.allUserList();
    }
}
