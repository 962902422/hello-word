<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<%-- <%-- <base href="<%=basePath%>"/> --%>
<meta charset="UTF-8">
<title>青鸟租房系统</title>

<link rel=stylesheet type=text/css href="<%=basePath %>css/style.css"/>

<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>

</head>

<body>


<DIV id=header class=wrap>
<DIV id=logo><img src="../images/logo.gif"></DIV></DIV>
<DIV id=regLogin class=wrap>
<DIV class=dialog>
<DL class=clearfix>
  <DT>新用户注册</DT>
  <DD class=past>填写个人信息</DD></DL>
<DIV class=box>
<FORM action="../RegServlet?action=reg" method="post">
<DIV class=infos>
<TABLE class=field>
  <TBODY>
  <TR>
    <TD class=field>用 户 名：</TD>
    <TD><INPUT class=text type=text name=names id=users onblur="test()"><span></span></TD></TR>
  <TR>
    <TD class=field>密　　码：</TD>
    <TD><INPUT class=text type=password name=password></TD></TR>
  <TR>
    <TD class=field>确认密码：</TD>
    <TD><INPUT class=text type=password name=repassword onblur="test2()"><span></span></TD></TR>
  <TR>
    <TD class=field>电　　话：</TD>
    <TD><INPUT class=text type=text name=telephone> </TD></TR>
  <TR>
    <TD class=field>用户姓名：</TD>
    <TD><INPUT class=text type=text name=username> </TD></TR></TBODY></TABLE>
<DIV class=buttons>
<INPUT  value=立即注册 type=submit>
</DIV></DIV></FORM></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
</body>
<script type="text/javascript">
		function test(){
			
			var $zhi=$("#users").val();
				
				if($zhi==null||$zhi==""){
					
				$("#users").next().html("用户名不能为空");
				$("#users").focus();
				return false;
			}else{
				
				$("#users").next().html("");
				$.post("../RegServlet",{"action":"find",username:$zhi},function(data){
					
					
					if(data=="false"){
						$("#users").next().html("用户名已存在");
						$("#users").focus();
						return false;
					}else{
						
						$("#users").next().html("用户名可以使用");
						return true;
					}
					
				},"text")
				
			}
		}
		
		function test2(){
			
			var $pwd=$("input[name=password]").val();
			
			 var $rpwd=$("input[name=repassword]").val();
			 
			 
			 if($pwd!=$rpwd){
				 
				 $("input[name=repassword]").next().html("两次密码不一致");
				 $("input[name=repassword]").focus();
				 return false;
			 }else{
				 $("input[name=repassword]").next().html("");
				 return true;
			 }
			 
			 
		}
</script> 

</html>