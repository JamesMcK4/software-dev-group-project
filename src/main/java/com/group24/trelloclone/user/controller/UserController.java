package com.group24.trelloclone.user.controller;

import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/save_user")
    public UserModel addUser(@RequestBody UserModel userModel)
    {
        return userService.addUser(userModel);
    }

    @GetMapping("/get_user/{id}")
    public UserModel getUserById(@PathVariable("id") Long userId) throws InvalidUserIdException
    {
        UserModel user =  userService.getUserById(userId);
        return user;
    }

    @GetMapping("/get_all_users")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @DeleteMapping("/delete_all_users")
    public boolean deleteAllUsers()
    {
        return userService.deleteAllUsers();
    }
}

