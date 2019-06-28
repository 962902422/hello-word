<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
				<IMG src="images/logo.gif">
			</DIV>
		</DIV>
		<DIV id=regLogin class=wrap>
			<DIV class=dialog>
				<DL class=clearfix>
					<DT>
						新房屋信息发布
					</DT>
					<DD class=past>
						填写房屋信息
					</DD>
				</DL>
				<DIV class=box>
					<FORM id='add_action' method='post' action="HouseServlet?action=add">
						<DIV class=infos>
							<TABLE class=field>
								<TBODY>
									<TR>
										<TD class=field>
											标 题：
										</TD>
										<TD>
											<INPUT type=hidden name=id value="">
											<INPUT id='add_title' class=text type=text name=title value="">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											户 型：
										</TD>
										<TD>
											<select name="type" id="type">
												<option value="0" selected=selected>
													--请选择--
												</option>
												<c:forEach items="${leixin}" var="lei">				
													<option class='tp' value="${lei.hid}">
														${lei.htype}
													</option>
																		
												</c:forEach>	
													
												
											</select>   
										</TD>
									</TR>
									<TR>
										<TD class=field>
											面 积：
										</TD>
										<TD>
											<INPUT id='add_floorage' class=text type=text
												name=floorage value="">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											价 格：
										</TD>
										<TD>
											<INPUT id='add_price' class=text type=text name=price value="">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											房产证日期：
										</TD>
										<TD>
											<INPUT id='add_date' class=text type=text name=houseDate value="">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											位 置：
										</TD>
										<TD>
											区：
											<select name="dis" id="dis">
												<option value="0" selected=selected>
													--请选择--
												</option>
												<c:forEach items="${qu}" var="q">
													<option class='ds' value="${q.did}">
														${q.aname }
													</option>
												
												</c:forEach>
											</select>
											街：
											<select name="street" id="street">
												<option value="0" selected=selected>
													--请选择--
												</option>
											</select>   
										</TD>
									</TR>
									<TR>
										<TD class=field>
											联系方式：
										</TD>
										<TD>
											<INPUT id=add_action_contact class=text type=text
												name=contact value="">
										</TD>
									</TR>
									<TR>
										<TD class=field>
											详细信息：
										</TD>
										<TD>
											<TEXTAREA name=description></TEXTAREA>
										</TD>
									</TR>
								</TBODY>
							</TABLE>
							<DIV class=buttons>
								<INPUT  value='立即发布' type='submit'>
							</DIV>
						</DIV>
					</FORM>
				</DIV>
			</DIV>
		</DIV>
		<DIV id=footer class=wrap>
			<DL>
				<DT>
					青鸟租房 © 2010 北大青鸟 京ICP证1000001号
				</DT>
				<DD>
					关于我们 · 联系方式 · 意见反馈 · 帮助中心
				</DD>
			</DL>
		</DIV>

</body>
<script type="text/javascript">
		function ch(){
			
			var $zhi=$("#dis").val();
			
			var html="<option value='0'>--请选择--</option>";
			$.post("HouseServlet",{"action":"change","zhi":$zhi},function(data){
				
				if(data!=null){
					
					for(var i=0;i<data.length;i++){
						
					html+="<option value='"+data[i].sid+"'>"+data[i].sname+"</option>";	
					
					}
					
				}
				
				$("#street").html(html);
				
			},"json")
			
		}
		
		
		$("#dis").change(ch)
		</script>
</html>