package com.cssl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cssl.pojo.User;
import com.cssl.servce.UserDaoServce;
import com.cssl.servce.UserDaoServceimpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	UserDaoServce uds=new UserDaoServceimpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		//System.out.println("action"+action);
		if("find".equals(action)) {
			
			String name = request.getParameter("username");
			
			int num = uds.selectname(name);
			if(num>0) {
				//存在相同用户
				out.write("false");
				
			}else {
				out.write("true");
			}
				
				out.flush();
			
			
		}else if("reg".equals(action)) {
			
			//System.out.println("进来了吗");
			String username = request.getParameter("names");
			String pwd = request.getParameter("password");
			String tel = request.getParameter("telephone");
			String names = request.getParameter("username");
			User u=new User();
			u.setUsername(username);
			u.setUserpwd(pwd);
			u.setPhone(tel);
			u.setNames(names);
			int num = uds.insertuser(u);
			String mess="添加成功";
			if(num>0) {
				out.write("<script>");
		     	out.write("alert('"+mess+"');");
		     	out.write("location.href='page/index.jsp'");
				out.write("</script>");
			}else {
				mess="添加失败";
				out.write("<script>");
		     	out.write("alert('"+mess+"');");
		     	out.write("location.href='page/regs.jsp'");
				out.write("</script>");
				
			}
		}
		
		
	}

}
