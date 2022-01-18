package com.intellius.classmate.user.service.impl;

import com.intellius.classmate.apiResponse.ApiResponse;
import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.user.entity.User;
import com.intellius.classmate.user.entity.User2;
import com.intellius.classmate.user.repository.UserRepository;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User getUser(String id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundUserException("UserServiceImpl - 29"));
    }

    @Override
    public ApiResponseMessage saveUser(User user){
        String messageText;

        if(!userRepository.findById(user.getId()).isPresent()) {
            messageText = "토큰 저장 성공";
        }else{
            messageText = "토큰 업데이트 성공";
        }

        userRepository.save(user);

        ApiResponseMessage apiResponseMessage =
                ApiResponseMessage.builder().data(user).message(messageText).build();

        return apiResponseMessage;
    }

    @Override
    public List<User> allUserList(){
        return userRepository.findAll();
    }
}
