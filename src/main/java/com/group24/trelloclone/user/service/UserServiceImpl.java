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
    public UserModel getUserByEmailId(String emailId) {

        Optional<UserModel> optionalUser = userRepository.findByEmailId(emailId);
        UserModel user = null;

        if(!optionalUser.isEmpty()){
            user = optionalUser.get();
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

        if(!user.getPassword().equals(password)){
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
        UserModel user = null;
        Optional<UserModel> optionalUser = userRepository.findByEmailId(email);
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