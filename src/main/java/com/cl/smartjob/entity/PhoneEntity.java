package com.cl.smartjob.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.cl.smartjob.controller.dto.Phone;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "phones")
@ToString
@Data
public class PhoneEntity {

	@Id
	@NotNull
    private String id;
	
	@Column(name="number")
	private String number;
	
	@Column(name="city_code")
	private String cityCode;
	
	@Column(name="country_code")
	private String countryCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserEntity user;

	public PhoneEntity(Phone phone, UserEntity userEntity ) {
		
		this.id = UUID.randomUUID().toString();
		this.number = phone.getNumber();
		this.cityCode = phone.getCityCode();
		this.countryCode = phone.getCountryCode();
		this.user = userEntity;
	}

	public PhoneEntity() {
		
	}
	
}
