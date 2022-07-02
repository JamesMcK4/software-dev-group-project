package com.group24.trelloclone.user;

import static org.junit.jupiter.api.Assertions.*;

import com.group24.trelloclone.exception.InvalidCredentialsException;
import com.group24.trelloclone.exception.InvalidUserIdException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;


import com.group24.trelloclone.user.service.UserService;
import com.group24.trelloclone.user.service.UserServiceImpl;
import com.group24.trelloclone.user.repository.UserRepository;
import com.group24.trelloclone.user.model.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {

	@Mock
	@Autowired
	private UserRepository userRepository;

	@InjectMocks
	private UserService usersServiceImpl = new UserServiceImpl();

    //setting up objects and other needed entities for testing purposes.
    private UserModel user1;
    private UserModel user2;

    private List<UserModel> userList = new ArrayList<>();

    //setting up a method to be run before each test for setup and testing purposes.
    @BeforeEach
    public void build(){
        //first create new users
        user1 = new UserModel("James", "McKinlay", "testemail@hi.com", "Helloo4!");
        user2 = new UserModel("Test", "Test", "TestEmail@Test.com", "test");
        //set Ids to test getId methods - (Also, apparently adding L to the end is casting now?)
        user1.setId(1L);
        user2.setId(2L);
        //Add users to list to test getAllUsers
        userList.add(user1);
        userList.add(user2);
    }

    @Test
    public void addUserTest(){
        Mockito.when(userRepository.save(user1)).thenReturn(user1);
        assertEquals(user1, usersServiceImpl.addUser(user1));
    }
    @Test
    public void getUserByIdTest() throws InvalidUserIdException {
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user1));
        assertEquals(user1, usersServiceImpl.getUserById(1L));
    }
    @Test
    public void getAllUsersTest(){
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        assertEquals(userList, usersServiceImpl.getAllUsers());
    }
    @Test
    public void getUserByEmailIdTest() throws InvalidCredentialsException {
        Mockito.when(userRepository.findByEmailId("testemail@hi.com")).thenReturn(Optional.of(user1));
        assertEquals(user1, usersServiceImpl.getUserByEmailId("testemail@hi.com"));
    }
    @Test
    public void deleteAllUsersTest(){
        Mockito.when(userRepository.count()).thenReturn(0L);
        assertTrue(usersServiceImpl.deleteAllUsers());
        //had to check Nhi's version of this test, it stumped me for awhile
    }
    @Test
    public void validateUserTest(){
        //Need to finish this
    }
    @Test
    public void updatePasswordTest(){
        
    }
}

/*References
1. https://stackoverflow.com/questions/30946167/mockito-error-with-method-that-returns-optionalt for reference of Optional.of
2. https://mkyong.com/spring-boot/mockito-how-to-mock-repository-findbyid-thenreturn-optional/
 */

