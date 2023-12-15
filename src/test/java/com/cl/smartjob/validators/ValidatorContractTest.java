package com.cl.smartjob.validators;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.error.ContractInvalidException;
import com.cl.smartjob.validators.ValidatorContract;


class ValidatorContractTest {
	
	
	@BeforeEach
	public void before() {

	}

	@Test
	void testValidateEmailRequest() {
		
		User user = new User();
		user.setEmail("hun");
		user.setPassword("hunter2$");
		assertThrows(ContractInvalidException.class, () -> ValidatorContract.validateRequest(user));
	    
	}
	
	@Test
	void testValidatePasswordRequest() {
		
		User user = new User();
		user.setEmail("hunter2@gmail.com");
		user.setPassword("hunter2$qwklsuhbsjhsdfgfd");
		assertThrows(ContractInvalidException.class, () -> ValidatorContract.validateRequest(user));
		
	}


}
