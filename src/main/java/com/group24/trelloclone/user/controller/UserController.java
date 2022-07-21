package com.group24.trelloclone.user.controller;

import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;
import com.group24.trelloclone.user.model.UserLoginModel;
import com.group24.trelloclone.user.model.UserModel;
import com.group24.trelloclone.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.group24.trelloclone.utils.Response.*;
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
    @PostMapping()

    @GetMapping("/get_user/{id}")
    public UserModel getUserById(@PathVariable("id") Long userId) throws InvalidUserIdException
    {
        UserModel user =  userService.getUserById(userId);
        return user;
    }

    @GetMapping("/get_email/{id}")
    public ResponseEntity<Map<String, Object>> getUserByEmail(@PathVariable("id") String emailId) throws InvalidCredentialsException {
        UserModel user;
        try{
            user = userService.getUserByEmailId(emailId);
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(VALIDATED.getValue(), false));
        }
        Map<String, Object> returnBody = new HashMap<>();
        returnBody.put(VALIDATED.getValue(), true);
        returnBody.put(ID.getValue(), user.getId());
        return status(HttpStatus.OK).body(returnBody);
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

    //Work on this for validation.
    @PostMapping(path = "/validate_user", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> validateUser(@RequestBody UserLoginModel userloginModel)
    {   
        UserModel user;
        try{
            user = userService.validateUser(userloginModel);
        }
        catch(Exception e){
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(VALIDATED.getValue(), false));
        }
        Map<String, Object> returnBody = new HashMap<>();
        returnBody.put(VALIDATED.getValue(), true);
        returnBody.put(ID.getValue(), user.getId());
        return status(HttpStatus.OK).body(returnBody);
    }

    //needs insight - ask questions
    @PutMapping("/updatePassword")
    public ResponseEntity<Map<String, Object>> updatePassword(@RequestBody UserLoginModel userLoginModel) {
        UserModel user;
        try{
            user = userService.updatePassword(userLoginModel);
        }
        catch(Exception e) {
            System.out.println(e);
            return status(HttpStatus.OK).body(singletonMap(MESSAGE.getValue(), e.getMessage())); //this shouldnt be VALIDATION STATUS but not sure what to put here..ask advicepo
        }
        return status(HttpStatus.OK).body(singletonMap(OBJECT.getValue(), user));
    }

}
