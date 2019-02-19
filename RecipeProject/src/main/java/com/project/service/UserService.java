package com.project.service;

import com.project.Entity.User;
import com.project.dto.UserDto;

public interface UserService {
	
	public boolean save(UserDto userdto);
	public boolean update(UserDto userDto);
	
	public UserDto findUserByUsPass(String username,String password);
	public UserDto findUserByUsEmail(String username ,String email);
	public boolean updatePassword(String password,int userId);
	

}
