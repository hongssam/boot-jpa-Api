package com.intellius.classmate.user.service.impl;

import com.intellius.classmate.apiResponse.ApiResponseMessage;
import com.intellius.classmate.user.entity.User;
import com.intellius.classmate.user.entity.User2;
import com.intellius.classmate.user.repository.UserRepository;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ApiResponseMessage getUser(String id) throws Exception{
        String messageText;
        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            messageText = "존재하지 않는 사용자";
        }else{
            messageText = "조회 성공";
        }

        User2 user2 = User2.builder()
                .userInfo(User2.UserInfo.builder()
                        .id("123")
                        .build())
                .userDetail(User2.UserDetail.builder()
                        .name("jinpyo")
                        .token("AWEF123!@#")
                        .build())
                .build();

        ApiResponseMessage apiResponseMessage =
                ApiResponseMessage.builder().data(user).message(messageText).build();

        return apiResponseMessage;
    }

    @Override
    public ApiResponseMessage saveUser(User user) throws Exception{
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
    public ApiResponseMessage allUserList() throws Exception{
        ApiResponseMessage apiResponseMessage =
                ApiResponseMessage.builder().data(userRepository.findAll()).message("호출 성공").build();

        return apiResponseMessage;
    }
}
