package com.cssl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cssl.pojo.District;
import com.cssl.pojo.House;
import com.cssl.pojo.Hstype;
import com.cssl.pojo.Street;
import com.cssl.pojo.User;
import com.cssl.servce.HouseDaoServce;
import com.cssl.servce.HouseDaoServceimpl;
import com.cssl.servce.UserDaoServce;
import com.cssl.servce.UserDaoServceimpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;


@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		this.doPost(request, response);
	
		
	}

	UserDaoServce uds=new UserDaoServceimpl();
	HouseDaoServce hds=new HouseDaoServceimpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String index = request.getParameter("index");
		
		if("log".equals(action)) {
			String names = request.getParameter("name");
			String pwd = request.getParameter("password");
			User u=new User();
			u.setUsername(names);
			u.setUserpwd(pwd);
			User log = uds.selectlog(u);
			String mess="登录失败";
			
			if(log!=null) {
			
				session.setAttribute("users",log);
				selecthouse(request, response);
				
				
				
			}else {	
				
				out.write("<script>");
		     	out.write("alert('"+mess+"');");
		     	out.write("location.href='page/index.jsp'");
				out.write("</script>");
			}
			out.flush();
		}else if("logout".equals(action)) {
			
			if(session!=null) {
				session.invalidate();
			}	
			out.write("<script>");
	     	out.write("location.href='page/index.jsp'");
			out.write("</script>");
		}else if("find".equals(action)) {
			
			
			String names = request.getParameter("username");
			System.out.println(names);
			
		}else if("cha".equals(action)) {
			selecthouse(request, response);
		}else if("sou".equals(action)) {
			
			
			
			selecthouse(request, response);
			
		}
	
			
	}
	
	
	
	public void selecthouse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session = request.getSession();
		String index = request.getParameter("index");
		System.out.println("index的值"+index);
		if(index==null||index=="") {
			index="1";
		}
		User u =(User)session.getAttribute("users");
		//获取条件参数
		int id=0;
		String hname = request.getParameter("title");
		String mj = request.getParameter("floorage");
		String qian = request.getParameter("price");
		String lx = request.getParameter("type");
		String qu = request.getParameter("dis");
		String jie = request.getParameter("street");
		
		//创建map
		Map<String,Object> map=new HashMap<String,Object>();
		//与xml映射的值相对应
		map.put("hname",hname);
	
		if(u!=null) {
			
			id=u.getUserid();
		}
		map.put("userid",id);
		//面积和价格需要截取
		System.out.println("面积"+mj);
		if(mj!=null&&!mj.equals("0")&&mj!="") {
			String[] mianji = mj.split("-");
			map.put("area1",mianji[0]);
			System.out.println("面积1:"+mianji[0]);
			System.out.println("面积2:"+mianji[1]);
			map.put("area2",mianji[1]);
		}
		if(qian!=null&&!qian.equals("0")&&qian!="") {
			String[] moeny = qian.split("-");
			map.put("price1",moeny[0]);
			map.put("price2",moeny[1]);
		}	
		map.put("types", lx);
		map.put("qu",qu);
		map.put("jie",jie);
		System.out.println("我"+jie);
		//回显
		request.setAttribute("ming",hname);
		request.setAttribute("leixin",lx);
		request.setAttribute("mian",mj);
		request.setAttribute("money",qian);
		request.setAttribute("qua",qu);
		request.setAttribute("jie",jie);
		Page<House> page = PageHelper.startPage(Integer.valueOf(index),2,"hiredate desc");
		List<House> list = hds.selectAll(map);
		request.setAttribute("num",page.getPageNum());
		request.setAttribute("total",page.getPages());
		request.setAttribute("All",page);
		List<Hstype> types = hds.selecttype();
		List<District> era = hds.selectearea();
		request.setAttribute("dist",era);
		request.setAttribute("htype",types);
		request.getRequestDispatcher("page/guanli.jsp").forward(request, response);
	  
	};	
}
