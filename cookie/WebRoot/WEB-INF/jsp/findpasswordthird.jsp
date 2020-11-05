<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
Long onedayLong = 1000l*60l*60l*24l;
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires",0);
request.setAttribute("contextPath",request.getContextPath());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/public/css/master.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath}/public/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<div class="headtitle">
	<div class="tophead">
		<div class="topheadleft">
			<a>欢迎您来到北京安信通</a>
		</div>
		<div  class="topheadright">
				<a>注册</a>/ <a>登录</a>
		
		</div>
	</div>
</div>

<div class="findpasswdthird">

	<div class="nav" style="position: relative;">
		<div style="float: left;">
			<img src="${pageContext.request.contextPath}/public/images/logo.png" style="width:60px;height: 60px; vertical-align: top; margin-top: 20px;margin-left: 30px;"  />
		</div>
		<div style="width:110px;height: 50px;line-height: 50px; border-left: 1px solid #F0F0F0; font-size: 18px;font-weight: bolder;display:block; position: absolute; top:25px; left:120px;">
			找回密码
		</div>
	</div>
	
	
	
	<div class="content">
	
	<div class="contentleft">
	
		<img src="${pageContext.request.contextPath}/public/images/third.png" style="margin-top: 50px;"/>
	
	</div>
	
	<div class="contentright">
			<form>
				<div class="field" style="position: relative;  color: green; border: 0px;">
					<img src="${pageContext.request.contextPath}/public/images/findright.png" style="position: absolute;"/> <span style="margin-left: 50px;">恭喜您，找回密码成功！</span>
				</div>
				<div  class="field" style="position: relative; border: 0px;">
				
					<a  href="#" style="display:block;left:35px; position: absolute; color: green;">进入首页</a>  	
					<a href="${pageContext.request.contextPath}/member/toLogin.do" style="display:block;right:150px; position: absolute; color: green;">登录</a>
					
				</div >
				
				
			</form>
	
	
	</div>

	
	
	
	</div>
	
	<div class="foot">
	<p></p>
	<p></p>
	<p></p>
		<p>Copyright2004-2016  京东JD.com 版权所有 </p>
	
	</div>


</div>




</body>
</html>