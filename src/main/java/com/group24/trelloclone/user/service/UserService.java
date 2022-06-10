package com.group24.trelloclone.user.service;

import com.group24.trelloclone.user.model.UserModel;

import java.util.List;

public interface UserService
{
    public UserModel addUser(UserModel userModel);
    public UserModel getUserById(Long userId);
    public List<UserModel> getAllUsers();
}
