package com.cl.smartjob.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.cl.smartjob.constants.Constants;
import com.cl.smartjob.controller.dto.User;
import com.cl.smartjob.error.ContractInvalidException;

@Component
public class ValidatorContract {
	
	public static void validateRequest(User user, String regex) throws ContractInvalidException {
	    validateEmail(user.getEmail());
	    validatePassword(user.getPassword(),regex);
	}
	
	private static void validateEmail(String mail) throws ContractInvalidException {
		String regx = Constants.REGX_MAIL;
	    Pattern pattern = Pattern.compile(regx);
	    
	    Matcher matcher = pattern.matcher(mail);
	    
	    if(!matcher.matches()) {
	    	throw new ContractInvalidException(Constants.EMAIL_FORMAT_ERROR);
	    }
	}
	
	private static void validatePassword(String password, String regexPassword) throws ContractInvalidException {

	    Pattern pattern = Pattern.compile(regexPassword);
	    Matcher matcher = pattern.matcher(password);
	    
	    if(!matcher.matches()) {
	    	throw new ContractInvalidException(Constants.PASSWORD_FORMAT_ERROR);
	    }
	}

}
