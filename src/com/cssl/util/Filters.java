package com.cssl.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

@WebFilter("/*")
public class Filters implements Filter {

	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chan)
			throws IOException, ServletException {
		
		SqlSession session = MyBatisUtil.getSession();
		
			try {
				chan.doFilter(srequest, sresponse);
				session.commit();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				session.rollback();
				e.printStackTrace();
			}finally {
				MyBatisUtil.closeSession();
				
			}
			
	}
	
	@Override
	public void destroy() {
		

	}
	
}
