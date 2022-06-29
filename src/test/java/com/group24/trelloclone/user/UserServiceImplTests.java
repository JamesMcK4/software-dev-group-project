package com.group24.trelloclone.user;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.group24.trelloclone.user.service.UserService;
import com.group24.trelloclone.user.service.UserServiceImpl;
import com.group24.trelloclone.user.repository.UserRepository;;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTests {
	
	@Mock
	@Autowired
	private UserRepository UserRepository;
	
	@InjectMocks
	private UserService UsersServiceImpl = new UserServiceImpl();
}
