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

    //Not sure this is needed either, as there really isn't a reason to delete a single user, and we already have a delete all
    @CrossOrigin
    @DeleteMapping("/delete_user/{id}")
    public UserModel deleteUser(@PathVariable("id") Long id) throws InvalidUserIdException { return userService.deleteUser(id); }


    //Work on this for validation.  Edit 06/30/2022 Not sure this is needed for anything really..
    @CrossOrigin
    @GetMapping("/validate_user/{id}") //THIS DOESNT WORK YET
    public boolean validateUser(@PathVariable("id") String emailId, String password) throws InvalidUserIdException, EmptyPasswordException, InvalidCredentialsException
    {
            return userService.validateUser(emailId,password);
    }

    //needs insight - ask questions
    @CrossOrigin
    @GetMapping("/updatePassword")
    public boolean updatePassword(String email, String newPassword) throws EmptyPasswordException, InvalidUserIdException {
        return userService.updatePassword(email, newPassword);
    }

}
