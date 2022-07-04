package com.group24.trelloclone.user.service;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserLoginModel;
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
    public UserModel getUserByEmailId(String emailId) throws InvalidCredentialsException{

        Optional<UserModel> optionalUser = userRepository.findByEmailId(emailId);
        UserModel user = null;

        if(!optionalUser.isEmpty()){
            user = optionalUser.get();
        }
        else{
            throw new InvalidCredentialsException();
        }

        return user;
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
    public boolean validateUser(UserLoginModel loginCredentials) throws EmptyPasswordException, InvalidCredentialsException {

        String emailId = loginCredentials.getEmailId();
        String password = loginCredentials.getPassword();

        UserModel user = null;
        Optional<UserModel> optionalUser = userRepository.findByEmailId(emailId);

        if(optionalUser.isEmpty()){
           throw new InvalidCredentialsException();
        }
        else {
            user = optionalUser.get();
        }
        if(!user.getPassword().equals(password) || !user.getEmailId().equals(emailId)){
            throw new InvalidCredentialsException();
        }
        else{
            return true;
        }
    }

    //Not sure this method is needed either, as there is already a deleteAll
    @Override
    public UserModel deleteUser(Long userId) throws InvalidUserIdException {

        Optional<UserModel> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new InvalidUserIdException();
        }
        else{
            userRepository.deleteById(userId);
        }


        return null;
    }

    public boolean updatePassword(String emailId, String newPassword) throws EmptyPasswordException, InvalidUserIdException {

        //String emailId = loginCredentials.getEmailId();
        //String password = loginCredentials.getPassword();

        UserModel user = null;
        Optional<UserModel> optionalUser = userRepository.findByEmailId(emailId);

        if(optionalUser.isPresent()){
            user = optionalUser.get();
        }
        else{
            throw new InvalidUserIdException();
        }

        user.setPassword(newPassword);
        userRepository.save(user);
        return true;
    }
}