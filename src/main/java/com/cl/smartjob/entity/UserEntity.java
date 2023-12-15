package com.cl.smartjob.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cl.smartjob.controller.dto.User;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "users")
@ToString
@Data
public class UserEntity {
	
	@Id
	@NotNull
    private String id;
	
    @Column(name="name")
    private String name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="created")
    private Date created;
    
    @Column(name="modified")
    private Date modified;
    
    @Column(name="last_login")
    private Date lastLogin;
    
    @Column(name="isactive")
    private Boolean isActive;
    
    @Column(name="token")
    private String token;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<PhoneEntity> phones;

	public UserEntity(User user) {
		this.id = UUID.randomUUID().toString();
		this.name = user.getName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phones = new ArrayList<PhoneEntity>();
		this.created = new Date();
		this.modified = new Date();
		this.lastLogin = new Date();
		this.isActive = true;
		this.token = UUID.randomUUID().toString();
	}

	public UserEntity() {

	}
    

}
