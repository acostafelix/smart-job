package com.cl.smartjob.service;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.controller.dto.response.UserResponse;
import com.cl.smartjob.error.UserException;


public interface UserService {

	public UserResponse processUser(User user) throws UserException;
}
