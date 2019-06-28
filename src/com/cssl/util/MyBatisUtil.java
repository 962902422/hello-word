package com.cssl.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private static SqlSessionFactory factory;
	
	private static ThreadLocal<SqlSession> tol=new ThreadLocal<>();
	
	static {
		InputStream is;
		
		try {
			is = Resources.getResourceAsStream("mybatis-config.xml");
					factory=new SqlSessionFactoryBuilder().build(is);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		public static SqlSessionFactory getFactory() {
		
		return factory;
		
		}
			
		public  static SqlSession getSession() {
			
			
			SqlSession sion = tol.get();
			if(sion==null) {
				 sion = factory.openSession();
				tol.set(sion);
			}
			
			return sion;
		}
		
		public static void closeSession() {
			
			SqlSession session = tol.get();
			if(session!=null) {
				session.close();
			}
			tol.set(null);
			
		}
		
		
}
