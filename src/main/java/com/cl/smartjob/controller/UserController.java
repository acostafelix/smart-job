package com.cl.smartjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.controller.dto.response.UserResponse;
import com.cl.smartjob.error.ContractInvalidException;
import com.cl.smartjob.error.UserException;
import com.cl.smartjob.service.UserService;
import com.cl.smartjob.validators.ValidatorContract;

@Controller
@RequestMapping("/api/v1/smart-job")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping(value="/usuario", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> insertUser(@RequestBody User user) throws UserException, ContractInvalidException {
		
		ValidatorContract.validateRequest(user);
		return new ResponseEntity<>(userService.processUser(user), HttpStatus.CREATED);

	}
	
}
