package com.cl.smartjob.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.entity.UserEntity;
import com.cl.smartjob.error.UserException;
import com.cl.smartjob.repository.UserRepository;
import com.cl.smartjob.service.impl.UserImpl;

@ExtendWith(MockitoExtension.class)
class UserImpTest {

	@InjectMocks
	public UserImpl userImpl;
	
	@Mock
	private UserRepository userRepository;
	
	private UserEntity userEntityDB;
	
	@BeforeEach
    public void before() {
		
		userEntityDB = new UserEntity();
	}
	
	@Test
	void testProcessUser() {
		
		 Mockito.doReturn(userEntityDB).when(userRepository).findByEmail(Mockito.any());
		 assertThrows(UserException.class, () -> userImpl.processUser(new User()));
			
	}

}
