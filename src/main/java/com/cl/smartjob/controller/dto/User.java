package com.cl.smartjob.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.cl.smartjob.entity.UserEntity;

import lombok.Data;

@Data
public class User {

	private String name;
	private String email;
	private String password;
	private List<Phone> phones;
	
	public User(UserEntity newUserEntity ) {
		super();
		this.name = newUserEntity.getName();
		this.email = newUserEntity.getEmail();
		this.password = newUserEntity.getPassword();
		this.phones = getPhones(newUserEntity);
	}
	
	
	public User() {
		
	}
	
	private List<Phone> getPhones(UserEntity newUserEntity){
		
		return newUserEntity.getPhones().stream().map(p -> {
			Phone phone = new Phone();
			phone.setCityCode(p.getCityCode());
			phone.setNumber(p.getNumber());
			phone.setCountryCode(p.getCountryCode());
            return phone;
        }).collect(Collectors.toList());
	}
}
