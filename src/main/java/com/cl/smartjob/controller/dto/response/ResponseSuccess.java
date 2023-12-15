package com.cl.smartjob.controller.dto.response;

import java.util.Date;

import com.cl.smartjob.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseSuccess {
	
	private String id;
	
	private Date created;
	
	private Date modified;
	
	@JsonProperty("last_login")
	private Date lastLogin;
	
	private String token;
	
	@JsonProperty("isactive")
	private Boolean isActive;

	public ResponseSuccess(UserEntity userEntity) {
		this.id = userEntity.getId();
		this.created = userEntity.getCreated();
		this.modified = userEntity.getModified();
		this.lastLogin = userEntity.getLastLogin();
		this.token = userEntity.getToken();
		this.isActive = userEntity.getIsActive();
	}
	
	public ResponseSuccess() {
		
	}
	
	
	

}
