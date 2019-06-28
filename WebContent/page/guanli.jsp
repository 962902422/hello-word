<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<LINK rel=stylesheet type=text/css href="css/style.css">
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>

</head>
<body>

	<DIV id=header class=wrap>
		<DIV id=logo>
			<IMG src="images/logo.gif" /> <span
				style="font: normal bold 16px 宋体;">${users.names}</span> <a
				style='padding-left: 30px' href='UserServlet?action=logout'>注销</a>
		</DIV>
	</DIV>
	<form action="UserServlet?action=sou" method="post">
		<DIV id=navbar class="wrap">
			<br /> 标题: <input type="text" name="title" value="${ming}" /> 面积: <select
				name="floorage" id="floorage">
				<option value="0">--请选择--</option>
				<option value="0-60" <c:if test="${mian eq '0-60'}">selected</c:if>>
					0-60</option>
				<option value="60-120"
					<c:if test="${mian eq '60-120'}">selected</c:if>>60-120</option>
				<option value="120-200"
					<c:if test="${mian eq '120-200'}">selected</c:if>>120-200
				</option>
			</select> 价格: <select name="price" id="price">
				<option value="0" selected=selected>--请选择--</option>
				<option value="0-600"
					<c:if test="${money eq '0-600'}">selected</c:if>>0-600</option>
				<option value="600-1200"
					<c:if test="${money eq '600-1200'}">selected</c:if>>
					600-1200</option>
				<option value="1200-2000"
					<c:if test="${money eq '1200-2000'}">selected</c:if>>
					1200-2000</option>
				<option value="2000-8000"
					<c:if test="${money eq '2000-8000'}">selected</c:if>>
					2000-8000</option>
			</select> 类型: <select name="type">
				<option value="0" selected=selected>--请选择--</option>
				<c:forEach items="${htype}" var="h">


					<option class='tp' value="${h.hid}"
						<c:if test="${leixin eq h.hid}">selected</c:if>>

						${h.htype}</option>
				</c:forEach>

			</select> 区县: <select name="dis" id="dis">
				<option value="0" selected='selected'>--请选择--</option>


				<c:forEach items="${dist}" var="di">

					<option class='ds' value="${di.did}"
						<c:if test="${qua eq di.did }">selected</c:if>>
						${di.aname}</option>

				</c:forEach>




			</select> 街道: <select name="street" id="street">
				<option value="0" selected="selected">--请选择--</option>
			</select> <LABEL class=ui-blue><INPUT value='搜索房屋' type='submit'
				name=search></LABEL> &nbsp;&nbsp;&nbsp;&nbsp; <a
				href="HouseServlet?action=fabu">发布房屋</a>
		</DIV>
	</form>

	<!-- 列表 -->
	<DIV class="main wrap">
		<TABLE class=house-list>
			<TBODY>
				<c:forEach var="e" items="${All}">






					<TR>
						<TD class=house-thumb><span><A href="details.htm"
								target="_blank"><img src="images/thumb_house.gif"
									width="100" height="75" alt=""> </a> </span></TD>
						<TD>
							<DL>
								<DT>
									<A href="details.htm" target="_blank">${e.hname}</A>
								</DT>
								<DD>
									${e.message} <BR> 联系方式：${e.tel}
								</DD>
							</DL>
						</TD>
						<TD class=house-type>${e.hstype.htype }</TD>
						<TD class=house-price><SPAN>${e.price}</SPAN>元/月</TD>
						<TD class=house-price><a href="HouseServlet?action=xiu&&uid=${e.id}">修改</a>
							<a class='del' title="17" href='javascript:void(0)'>删除</a> <span
							hidden="hidden" class="hid">${e.id}</span></TD>
					</TR>
				</c:forEach>

			</TBODY>
		</TABLE>

		<DIV class=pager>
			<UL>
				<LI class=current><A
					href="UserServlet?action=sou&&index=1&&title=${ming}&&floorage=${mian}&&price=${money}&&dis=${qua}&&type=${leixin}&&street=${jie}">首页</A>
				</LI>
				<LI><A
					href="UserServlet?action=sou&&index=${num-1}&&title=${ming}&&floorage=${mian}&&price=${money}&&dis=${qua}&&type=${leixin}&&street=${jie}">上一页</A>
				</LI>
				<LI><A
					href="UserServlet?action=sou&&index=${num+1}&&title=${ming}&&floorage=${mian}&&price=${money}&&dis=${qua}&&type=${leixin}&&street=${jie}">下一页</A>
				</LI>
				<LI><A
					href="UserServlet?action=sou&&index=${total}&&title=${ming}&&floorage=${mian}&&price=${money}&&dis=${qua}&&type=${leixin}&&street=${jie}">末页</A>
				</LI>
			</UL>
			<SPAN class=total>${num}/${total}页</SPAN>

		</DIV>
	</DIV>
	<DIV id=footer class=wrap>
		<DL>
			<DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
			<DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD>
		</DL>
	</DIV>

</body>
<script type="text/javascript">

	
	$(".del").click(function(){
		
		var y=confirm("确认删除吗？");
		if(y){
			var id=$(".hid").html();
			
			location.href="HouseServlet?action=shan&&id="+id;
		}
	})
	
	function ch(){
		
		var $zhi=$("#dis").val();
		var  $jie=$("#street").val();
		
		var html="<option value='0'>--请选择--</option>";
		$.post("HouseServlet",{"action":"change","zhi":$zhi},function(data){
			
			if(data!=null){
				
				for(var i=0;i<data.length;i++){
					
					
				
					if(data[i].sid=="${jie}"){
					
					html+="<option value='"+data[i].sid+"' selected>"+data[i].sname+"</option>";		
			
					}else{
						html+="<option value='"+data[i].sid+"'>"+data[i].sname+"</option>";	
					}
				
				}
				
			}
			
			$("#street").html(html);
			
		},"json")
		
	}
	
	
	$("#dis").change(ch)
	
	$(function(){
		
		ch();
		
	})
	
</script>
</html>