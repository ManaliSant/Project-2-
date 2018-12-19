package com.coll.dao;

import com.coll.models.UserDetail;

public interface UserDao {
	
	public boolean registerUser(UserDetail user);
	public boolean updateProfile(UserDetail user);
	public UserDetail getUser(String loginname);
	public UserDetail checkUserValidation(String loginname,String password);

}
