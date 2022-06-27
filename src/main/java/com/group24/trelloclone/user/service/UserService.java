package com.group24.trelloclone.user.service;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
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
    public boolean validateUser(String emailId, String password) throws EmptyPasswordException, InvalidCredentialsException;
    public boolean updatePassword(Long userId, String password) throws EmptyPasswordException, InvalidUserIdException;
    //TODO Reset password

    public void updatePassword(UserModel user, String newPassword);
}
