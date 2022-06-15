package com.group24.trelloclone.user.service;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserModel addUser(UserModel UserModel)
    {
        return userRepository.save(UserModel);
    }

    @Override
    public UserModel getUserById(Long userId)
    {
        UserModel user = null;
        Optional<UserModel> optionalUser = userRepository.findById(userId);
        if(optionalUser.isPresent())
        {
            user = optionalUser.get();
        }
        return user;
    }

    @Override
    public List<UserModel> getAllUsers()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteAllUsers(){
        userRepository.deleteAll();
        if (userRepository.count()==0){
            return true;
        }
        return false;
    }

    @Override
    public UserModel deleteUser(Long userId) throws InvalidUserIdException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean validateUser(String emailId, String password)
            throws EmptyPasswordException, InvalidCredentialsException {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updatePassword(Long userId, String password) throws EmptyPasswordException {
        // TODO Auto-generated method stub
        return false;
    }
}