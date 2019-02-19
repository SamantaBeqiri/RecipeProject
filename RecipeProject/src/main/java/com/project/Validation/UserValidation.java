package com.project.Validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import com.project.Entity.User;

public  class UserValidation implements Validator{

	public boolean supports(Class<?> arg0) {
		return User.class.equals(arg0);
	}

	public void validate(Object arg0, Errors errors) {
	}

	

	
}
