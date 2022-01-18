package com.intellius.classmate.user.controller;

import com.intellius.classmate.apiResponse.ApiResponse;
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
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value="/getuser")
    public ApiResponse<User> getUser(String id){
        // 유효성검증
        // 서비스 콜
        return ApiResponse.OK(userService.getUser(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<ApiResponseMessage> saveUser(@Validated @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new ValidationException();
        }
        return new ResponseEntity<>( userService.saveUser(user), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ApiResponse<List<User>> allUserList(){
        return ApiResponse.OK(userService.allUserList());
    }
}
