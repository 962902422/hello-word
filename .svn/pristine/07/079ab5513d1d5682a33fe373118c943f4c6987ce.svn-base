package com.cssl.servce;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cssl.pojo.District;
import com.cssl.pojo.House;
import com.cssl.pojo.Hstype;
import com.cssl.pojo.Street;

public interface HouseDaoServce {

	
	public List<House> selectAll(Map<String,Object> map);
	
	
	public List<Hstype> selecttype();
	
	
	public List<District> selectearea();
	
	public List<Street> selectstreet(String zhi);
	
	public int inserthouse(Map<String,Object> map);
	
	public Map<String,Object> selecthouse(@Param("id")String id);
	
	public int update(Map<String,Object> map);
	
	public int delete(@Param("id") String id);
}
