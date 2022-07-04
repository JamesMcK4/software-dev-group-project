package com.group24.trelloclone.user.service;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserLoginModel;
import com.group24.trelloclone.user.model.UserModel;

import java.util.List;

public interface UserService
{
    public UserModel addUser(UserModel userModel);
    public UserModel getUserById(Long userId) throws InvalidUserIdException;
    public List<UserModel> getAllUsers();
    public UserModel getUserByEmailId(String emailId) throws InvalidCredentialsException;
    public UserModel deleteUser(Long userId) throws InvalidUserIdException;
    public boolean deleteAllUsers();
    public boolean validateUser(UserLoginModel loginCredentials) throws EmptyPasswordException, InvalidCredentialsException;
    public UserModel updatePassword(UserLoginModel loginCredentials) throws EmptyPasswordException, InvalidUserIdException;

}
