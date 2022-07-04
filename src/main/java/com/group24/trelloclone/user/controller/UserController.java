package com.group24.trelloclone.user.controller;

import com.group24.trelloclone.exception.EmptyPasswordException;
import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserLoginModel;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.group24.trelloclone.utils.ApplicationConstant.*;
import static java.util.Collections.singletonMap;
import static org.springframework.http.ResponseEntity.status;

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

    @GetMapping("/get_email/{id}")
    public ResponseEntity<Map<String, UserModel>> getUserByEmail(@PathVariable("id") String emailId) throws InvalidCredentialsException {
        UserModel user;
        try {
            user = userService.getUserByEmailId(emailId);
        } catch (Exception e) {
            System.out.println(e);
            return status(HttpStatus.BAD_REQUEST).body(singletonMap("user", null));
        }
        return status(HttpStatus.OK).body(singletonMap("user", user));

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

    //Not sure this is needed either, as there really isn't a reason to delete a single user, and we already have a delete all
    @DeleteMapping("/delete_user/{id}")
    public UserModel deleteUser(@PathVariable("id") Long id) throws InvalidUserIdException { return userService.deleteUser(id); }


    //Work on this for validation.
    @PostMapping(path = "/validate_user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> validateUser(@RequestBody UserLoginModel userloginModel)
    {   
        try{
            userService.validateUser(userloginModel);
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(VALIDATION_STATUS, false));
        }
        return status(HttpStatus.OK).body(singletonMap(VALIDATION_STATUS, true));
    }

    //needs insight - ask questions
    @PostMapping("/updatePassword/")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody UserLoginModel userLoginModel) throws EmptyPasswordException, InvalidUserIdException {
        UserModel user;
        try{
            user = userService.updatePassword(userLoginModel);
        }
        catch(Exception e) {
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(OBJECT, null)); //this shouldnt be VALIDATION STATUS but not sure what to put here..ask advicepo
        }
        return status(HttpStatus.OK).body(singletonMap(OBJECT, user));
        //
    }

}
