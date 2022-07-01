package com.group24.trelloclone.user.service;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.*;

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
    public UserModel getUserByEmailId(String emailId) throws InvalidCredentialsException {

        UserModel user = userRepository.findByEmailId(emailId);

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

    //Not sure this method is needed for anything..
    @Override
    public boolean validateUser(String emailId, String password) throws EmptyPasswordException, InvalidCredentialsException {

        UserModel user = null;
        Optional<UserModel> optionalUser = Optional.ofNullable(userRepository.findByEmailId(emailId));

        if(optionalUser.isEmpty()){
           throw new InvalidCredentialsException();
        }
        else {
            user = optionalUser.get();
        }
        if(user.getPassword() != password){
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


        return null; //not sure what to return here since its a delete, maybe change to void?
    }

    public boolean updatePassword(String email, String password) throws EmptyPasswordException, InvalidUserIdException {

        //Probably dont need to make a whole new variable for the argument being passed in, but I like neatness
        String newPassword = password;
        Optional<UserModel> optionalUser = Optional.ofNullable(userRepository.findByEmailId(email));
        UserModel user = null;
        if(optionalUser.isEmpty()){
            throw new InvalidUserIdException();
        }
        else{
            user = optionalUser.get();
        }

        user.setPassword(newPassword);

        return true;
    }


    /*public boolean validatePassword(String password){

        String regexpression = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        //use Pattern class to compile the regular expression to later use for matching
        Pattern regPattern = Pattern.compile(regexpression);

        //check if password is empty
        if(password == null){
            return false;
        }

        //setup matcher from Pattern class to check regex against password
        Matcher matcher = regPattern.matcher(password);

        return matcher.matches();
    }*/
}