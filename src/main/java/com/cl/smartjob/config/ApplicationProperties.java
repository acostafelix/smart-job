package com.cl.smartjob.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ApplicationProperties {
	
	@Value("${smart-job.password.expresion}")
	private String regxPassword;

}
