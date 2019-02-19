 package com.project.dao;

import com.project.Entity.User;

public interface UserDao {
	
	public boolean save(User user);
	public boolean update(User user);
	
	public User findUserByUsPass(String username,String password);
	public User findUserByUsEmail(String username ,String email);
	public boolean updatePassword(String password,int userId);
	

}
