package com.intellius.classmate.user.controller;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.user.entity.User;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<ApiResponseMessage> getUser(@PathVariable Long id) throws Exception {
        Optional<User> user = userService.getUser(id);
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(user).message("조회 성공").build();

        return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public ResponseEntity<ApiResponseMessage> saveUser() throws Exception {
        User user = userService.saveUser();
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(user).message("호출 성공").build();

        return new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<ApiResponseMessage> allUserList() throws Exception{
        ApiResponseMessage apiResponseMessage = ApiResponseMessage.builder().data(userService.allUserList()).message("호출 성공").build();

        return  new ResponseEntity<>(apiResponseMessage, HttpStatus.OK);
    }
}
