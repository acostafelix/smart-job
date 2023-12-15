package com.cl.smartjob.validators;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.error.ContractInvalidException;


class ValidatorContractTest {
	
	@BeforeEach
	public void before() {

	}

	@Test
	void testValidateEmailRequest() {
		
		User user = new User();
		user.setEmail("hun");
		user.setPassword("hunter2$");
		assertThrows(ContractInvalidException.class, () -> ValidatorContract.validateRequest(user,""));
	    
	}
	
	@Test
	void testValidatePasswordRequest() {
		
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
		
		User user = new User();
		user.setEmail("hunter2@gmail.com");
		user.setPassword("hunter2$qwklsuhbsjhsdfgfd");
		assertThrows(ContractInvalidException.class, () -> ValidatorContract.validateRequest(user,regex));
		
	}


}
