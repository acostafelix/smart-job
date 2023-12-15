package com.cl.smartjob.controller.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ResponseError {
	
	@JsonProperty("mensaje")
	private String message;

	public ResponseError(String message) {
		super();
		this.message = message;
	}

}
