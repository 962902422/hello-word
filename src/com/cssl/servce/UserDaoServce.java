package com.cssl.servce;

import com.cssl.pojo.User;

public interface UserDaoServce {

	
	public User selectlog(User u);
	
	public int selectname(String name);
	
	public int insertuser(User u);
}
