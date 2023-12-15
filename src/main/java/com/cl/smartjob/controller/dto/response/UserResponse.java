package com.cl.smartjob.controller.dto.response;

import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.entity.UserEntity;

public class UserResponse extends ResponseSuccess{
	
	private User user;

	public UserResponse(UserEntity newUserEntity ) {
		super(newUserEntity);
		this.user = new User(newUserEntity);
	}
	
	public UserResponse() {
	
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
