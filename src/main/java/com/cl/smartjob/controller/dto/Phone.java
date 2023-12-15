package com.cl.smartjob.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Phone {
	
	private String number;
	
	@JsonProperty("citycode")
	private String cityCode;
	
	@JsonProperty("contrycode")
	private String countryCode;

}
