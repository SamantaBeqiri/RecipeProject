package com.project.converter;

import org.jasypt.util.password.BasicPasswordEncryptor;

import com.project.Entity.User;
import com.project.dto.UserDto;

public class UserConverter {
	
	public static User toUser(UserDto userDto) {
		if(userDto!=null) {
			User user=new User();
			user.setEmail(userDto.getEmail());
			user.setUsername(userDto.getUsername());
			BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();
			user.setPassword(encryptor.encryptPassword(userDto.getPassword()));
			user.setActive(true);
			return user;
		}else
			return null;
	}
	
	public static UserDto toUserDto(User user) {
		if(user!=null) {
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
			userDto.setActive(user.isActive());
			return userDto;
		}else
			return null;
	}

}
