package com.cl.smartjob.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.cl.smartjob.constants.Constants;
import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.controller.dto.response.UserResponse;
import com.cl.smartjob.entity.PhoneEntity;
import com.cl.smartjob.entity.UserEntity;
import com.cl.smartjob.error.UserException;
import com.cl.smartjob.repository.UserRepository;
import com.cl.smartjob.service.UserService;

@Primary
@Service
public class UserImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserResponse processUser(User user) throws UserException {
		
		UserEntity userEntityDB = userRepository.findByEmail(user.getEmail());
		
		if(!Optional.ofNullable(userEntityDB).isEmpty()) {
			throw new UserException(Constants.EMAIL_ALREADY_EXIST); 
		}
		
		return new UserResponse(userRepository.save(buildUserEntity(user)) );
		
	}

	private UserEntity buildUserEntity(User user) {
		UserEntity userEntity = new UserEntity(user);
		
		List<PhoneEntity> phones = user.getPhones().stream().map(p -> {
			return new PhoneEntity(p, userEntity);
        }).collect(Collectors.toList());
		
		userEntity.setPhones(phones);
		return userEntity;
	}

}
