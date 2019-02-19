package com.project.service.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Entity.User;
import com.project.converter.UserConverter;
import com.project.dao.UserDao;
import com.project.dto.UserDto;
import com.project.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	

	
@Transactional
	public boolean save(UserDto userDto) {
	
		
		return userDao.save(UserConverter.toUser(userDto));
	}
@Transactional
	public boolean update(UserDto userDto) {
		return userDao.update(UserConverter.toUser(userDto));
		
	}
@Transactional
	public UserDto findUserByUsPass(String username, String password) {
		
	User user=userDao.findUserByUsPass(username, password);
		if(user!=null) return UserConverter.toUserDto(user);
		else return null;
	}
@Transactional
public UserDto findUserByUsEmail(String username, String email) {
	
	return UserConverter.toUserDto(userDao.findUserByUsEmail(username, email));
}

	public boolean updatePassword(String password, int userId) {
		// TODO Auto-generated method stub
		return false;
	}

}
