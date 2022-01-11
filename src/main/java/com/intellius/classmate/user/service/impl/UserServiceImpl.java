package com.intellius.classmate.user.service.impl;

import com.intellius.classmate.apiResponse.Message;
import com.intellius.classmate.user.entity.User;
import com.intellius.classmate.user.repository.UserRepository;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<Message> getUserList(Long id) {
        try{
            Optional<User> user = userRepository.findById(id);

            Message message;

            if(user.isPresent()){
                message = Message.builder().data(user).message("조회 성공").build();
                return new ResponseEntity<>(message, HttpStatus.OK);
            }else{
                message = Message.builder().data(user).message("존재하지 않는 사용자").build();
                return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
            }

        }catch(Exception e){
            e.toString();
            Message message = Message.builder().data(null).message("호출 실패").build();

            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Message> saveUser() {
        User user = new User();
        try{
            user.setName("hong");
            user.setAge(32);

            Message message = Message.builder().data(userRepository.save(user)).message("호출 성공").build();

            return new ResponseEntity<>(message, HttpStatus.OK);
        }catch(Exception e){
            e.toString();
            Message message = Message.builder().data(null).message("호출 실패").build();

            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity allUserList(){

        Message message = Message.builder().data(userRepository.findAll()).message("호출 성공").build();

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
