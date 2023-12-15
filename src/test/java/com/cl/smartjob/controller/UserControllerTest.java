package com.cl.smartjob.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.controller.dto.response.UserResponse;
import com.cl.smartjob.error.ContractInvalidException;
import com.cl.smartjob.error.UserException;
import com.cl.smartjob.service.UserService;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@InjectMocks
	UserController controller;

	@Mock
	UserService userService;

	private User user;

	@BeforeEach
	public void before() {

		user = new User();
		user.setEmail("felixacosta@gmail.com");
		user.setName("felix acosta");
		user.setPassword("Smart@Job20");
		user.setPhones(null);
	}

	@Test
	void testInsertUser() throws UserException, ContractInvalidException {

		Mockito.doReturn(new UserResponse()).when(userService).processUser(Mockito.any());
		assertEquals(HttpStatus.CREATED, controller.insertUser(user).getStatusCode());
	}
}
