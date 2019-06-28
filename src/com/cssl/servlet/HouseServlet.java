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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cssl.pojo.District;
import com.cssl.pojo.House;
import com.cssl.pojo.Hstype;
import com.cssl.pojo.Street;
import com.cssl.pojo.User;
import com.cssl.servce.HouseDaoServce;
import com.cssl.servce.HouseDaoServceimpl;

/**
 * Servlet implementation class HouseServlet
 */
@WebServlet("/HouseServlet")
public class HouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HouseServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	HouseDaoServce hds=new HouseDaoServceimpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if ("fabu".equals(action)) {

				//System.out.println("我看見你了");
			if (session.getAttribute("users") == null) {

				out.write("<script>");
				out.write("alert('请先登录');");
				out.write("location.href='page/index.jsp'");
				out.write("</script>");
			}else {
				List<District> selectearea = hds.selectearea();
				List<Hstype> selecttype = hds.selecttype();
				request.setAttribute("qu",selectearea);
				request.setAttribute("leixin",selecttype);
				request.getRequestDispatcher("page/add.jsp").forward(request,response);
			
			}

		} else if ("xiu".equals(action)) {

			if (session.getAttribute("users") == null) {

				out.write("<script>");
				out.write("location.href='page/index.jsp'");
				out.write("</script>");
			}else {
				String uid = request.getParameter("uid");
				 Map<String, Object> map = hds.selecthouse(uid);
				 
				request.setAttribute("zhi",map);
				List<District> selectearea = hds.selectearea();
				List<Hstype> selecttype = hds.selecttype();
				request.setAttribute("qu",selectearea);
				request.setAttribute("leixin",selecttype);
				request.getRequestDispatcher("page/xiu.jsp").forward(request,response);
			
				
			}

		} else if ("shan".equals(action)) {
			
			if (session.getAttribute("users") == null) {

				out.write("<script>");
				out.write("location.href='page/index.jsp'");
				out.write("</script>");
			}else {
				String id = request.getParameter("id");
				
				int num = hds.delete(id);
				String mess="删除失败";
				if(num>0) {
					mess="删除成功";
					
				}
				out.write("<script>");
				out.write("alert('"+mess+"');");
				out.write("location.href='UserServlet?action=sou'");
				out.write("</script>");
			}
			
			
		}else if("change".equals(action)) {
			//System.out.println("进来了嘛");
			String zhi = request.getParameter("zhi");
			List<Street> list = hds.selectstreet(zhi);
			String json = JSON.toJSONString(list);
			out.write(json);
			out.flush();
		}else if("add".equals(action)) {
			User Us = (User)session.getAttribute("users");
			String hname = request.getParameter("title");
			String type = request.getParameter("type");
			String area = request.getParameter("floorage");
			String price = request.getParameter("price");
			String hiredate = request.getParameter("houseDate");
			String did = request.getParameter("dis");
			String sid = request.getParameter("street");
			String tel = request.getParameter("contact");
			String message = request.getParameter("description");
		Map<String,Object> map=new HashMap<String,Object>();
//`hname`, `hid`, `area`, `price`, `hiredate`, `did`, `sid`, `tel`, `message`
		map.put("userid",Us.getUserid());
		map.put("hname",hname);
		map.put("hid",type);
		map.put("area",area);
		map.put("price", price);
		map.put("hiredate", hiredate);
		map.put("did", did);
		map.put("sid", sid);
		map.put("tel", tel);
		map.put("message",message);
		int num = hds.inserthouse(map);
		String mess="添加成功";
			if(num>0) {
				
				out.write("<script>");
				out.write("alert('"+mess+"');");
				out.write("location.href='UserServlet?action=sou'");
				out.write("</script>");
				
			}else {
				mess="添加失败";
				out.write("<script>");
				out.write("alert('"+mess+"');");
				out.write("location.href='HouseServlet/action=fabu'");
				out.write("</script>");
				
				
			}
		
		
		}else if("update".equals(action)) {
			
			String id = request.getParameter("id");
			User Us = (User)session.getAttribute("users");
			String hname = request.getParameter("title");
			String type = request.getParameter("type");
			String area = request.getParameter("floorage");
			String price = request.getParameter("price");
			String hiredate = request.getParameter("houseDate");
			String did = request.getParameter("dis");
			String sid = request.getParameter("street");
			String tel = request.getParameter("contact");
			String message = request.getParameter("description");
			//
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("id",id);
			map.put("hname",hname);
			map.put("hid",type);
			map.put("area",area);
			map.put("price", price);
			map.put("hiredate", hiredate);
			map.put("did", did);
			map.put("sid", sid);
			map.put("tel", tel);
			map.put("message",message);
			int num = hds.update(map);
			String mess="修改成功";
			if(num>0) {
			
				out.write("<script>");
				out.write("alert('"+mess+"');");
				out.write("location.href='UserServlet?action=sou'");
				out.write("</script>");
				
			}else {
				
				out.write("<script>");
				out.write("alert('"+mess+"');");
				out.write("location.href='HouseServlet?action=xiu'");
				out.write("</script>");
			}
				
		}

	}

}
