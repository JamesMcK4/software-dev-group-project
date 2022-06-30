package com.group24.trelloclone.user.controller;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController
{
    @Autowired

    private UserService userService;

    @CrossOrigin
    @PostMapping("/save_user")
    public UserModel addUser(@RequestBody UserModel userModel)
    {
        return userService.addUser(userModel);
    }

    @CrossOrigin
    @GetMapping("/get_user/{id}")
    public UserModel getUserById(@PathVariable("id") Long userId) throws InvalidUserIdException
    {
        UserModel user =  userService.getUserById(userId);
        return user;
    }
    @CrossOrigin
    @GetMapping("/get_email/{id}")
    public UserModel getUserByEmail(@PathVariable("id") String emailId) throws InvalidCredentialsException {
        return userService.getUserByEmailId(emailId);

    }
    @CrossOrigin
    @GetMapping("/get_all_users")
    public List<UserModel> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @CrossOrigin
    @DeleteMapping("/delete_all_users")
    public boolean deleteAllUsers()
    {
        return userService.deleteAllUsers();
    }

    @CrossOrigin
    @DeleteMapping("/delete_user")
    public UserModel deleteUser(@PathVariable("id") Long id) throws InvalidUserIdException { return userService.deleteUser(id); }


    //Work on this for validation - need a mapping to test with Postman
    @CrossOrigin
    @GetMapping("/validate_user/") //THIS DOESNT WORK YET
        public boolean validateUser(@PathVariable("id") String emailId, String password) throws InvalidUserIdException, EmptyPasswordException, InvalidCredentialsException
    {
            return userService.validateUser(emailId,password);
    }

}
