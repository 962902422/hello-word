package com.cssl.servce;

import org.apache.ibatis.session.SqlSession;

import com.cssl.dao.UserDao;
import com.cssl.pojo.User;
import com.cssl.util.MyBatisUtil;

public class UserDaoServceimpl implements UserDaoServce {
	
	private UserDao udao;
	private SqlSession session;
	
	@Override
	public User selectlog(User u) {
		session = MyBatisUtil.getSession();
		udao = session.getMapper(UserDao.class);
		return udao.selectlog(u);
	}

	@Override
	public int selectname(String name) {
		session = MyBatisUtil.getSession();
		udao = session.getMapper(UserDao.class);
		return udao.selectname(name);
	}

	@Override
	public int insertuser(User u) {
		session = MyBatisUtil.getSession();
		udao = session.getMapper(UserDao.class);
		return udao.insertuser(u);
	}

}
