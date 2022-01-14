package com.intellius.classmate.user.controller;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.user.entity.User;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<ApiResponseMessage> getUser(@RequestParam String id) throws Exception {
        return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<ApiResponseMessage> saveUser(@Validated @RequestBody User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            throw new ValidationException();
        }
        return new ResponseEntity<>( userService.saveUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<ApiResponseMessage> allUserList() throws Exception{
        return  new ResponseEntity<>(userService.allUserList(), HttpStatus.OK);
    }
}
