package com.cssl.servce;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.cssl.dao.HouseDao;
import com.cssl.pojo.District;
import com.cssl.pojo.House;
import com.cssl.pojo.Hstype;
import com.cssl.pojo.Street;
import com.cssl.util.MyBatisUtil;

public class HouseDaoServceimpl implements HouseDaoServce {

	private SqlSession session;
	private HouseDao hdao;
	@Override
	public List<House> selectAll(Map<String,Object> map) {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		
		return hdao.selectAll( map);
	}
	
	@Override
	public List<Hstype> selecttype() {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		return hdao.selecttype();
	}

	@Override
	public List<District> selectearea() {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		return hdao.selectearea();
	}

	@Override
	public List<Street> selectstreet(String zhi) {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		return hdao.selectstreet(zhi);
	}

	@Override
	public int inserthouse(Map<String, Object> map) {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		return hdao.inserthouse(map);
	}

	@Override
	public Map<String, Object> selecthouse(String id) {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);	
		return hdao.selecthouse(id);
	}

	@Override
	public int update(Map<String, Object> map) {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		return hdao.update(map);
	}

	@Override
	public int delete(String id) {
		session = MyBatisUtil.getSession();
		hdao = session.getMapper(HouseDao.class);
		return hdao.delete(id);
	}

	

}
