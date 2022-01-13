package com.intellius.classmate.user.service.impl;

import com.intellius.classmate.user.entity.User;
import com.intellius.classmate.user.repository.UserRepository;
import com.intellius.classmate.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> getUser(Long id) throws Exception{

        if(id == Long.valueOf(1)){
            throw new AuthException();
        }

        Optional<User> user = userRepository.findById(id);

        if(!user.isPresent()) {
            throw new NullPointerException();
        }

        return user;
    }

    @Override
    public User saveUser() throws Exception{
        User user = new User();

        user.setName("hong");
        user.setAge(32);

        return userRepository.save(user);
    }

    @Override
    public List<User> allUserList() throws Exception{
        return userRepository.findAll();
    }
}
