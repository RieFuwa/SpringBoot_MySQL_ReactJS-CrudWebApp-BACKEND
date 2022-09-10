package com.bedirhankabatas.crudapplication.service;

import com.bedirhankabatas.crudapplication.exception.UserNotFoundException;
import com.bedirhankabatas.crudapplication.model.User;
import com.bedirhankabatas.crudapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addStudent(User user) {
        return  userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return  userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        return  userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
    }

    @Override
    public String deleteUserById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        userRepository.deleteById(userId);
        return "User with id " +userId+" has been deleted success.";
    }

    @Override
    public User updateUser(Long userId, User user) {
        Optional<User> update = userRepository.findById(userId);
        if (update.isPresent()){
            User getuser = update.get();
            getuser.setUserName(user.getUserName());
            getuser.setName(user.getName());
            getuser.setEmail(user.getEmail());
            getuser.setJob(user.getJob());
            return userRepository.save(getuser);
        }else {
            return null;
        }
    }
}
