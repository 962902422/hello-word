package com.cssl.dao;

import org.apache.ibatis.annotations.Param;

import com.cssl.pojo.User;

public interface UserDao {

	
	
	public User selectlog(User u);
	
	public int selectname(@Param("username")String name);
	
	public int insertuser(User u);
}
