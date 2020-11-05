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
	<script type="text/javascript">
		$(document).ready(function(){
			var isEmpty = true;
		
			$("#confirmpassword").focusout(function(){
				var password = $.trim($("#password").val());
				var confirmpassword = $.trim($("#confirmpassword").val());
				if(password != confirmpassword){
					alert("*两次密码不相同，请重新输入~~");
					isEmpty= false;
				}else{
					isEmpty = true;
				}
			});
		});
		
		$("#btn_ok").click(function(){
			alert(1);
			
			$("#confirmpassword").trigger("focusout");
			if(!isEmpty){
				return false;
			}
			var form = $("#myform");
			var password = $("#phone").val();
			$.ajax({
				type : "POST",
				rl: "${pageContext.request.contextPath}/member/UpdatePassword.do",
					contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
					cache:false,
					dataType : "json",
					data: $(form).serialize(),
					success: function(data){
		 			alert(data.message);
					if(data.state == 0){
						location.href="${pageContext.request.contextPath}/member/findPasswdthird.do";
						return false;
				 	}
				}
			});
			
			
		});
	
	</script>
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

<div class="findpasswdsecond">

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
	
		<img src="${pageContext.request.contextPath}/public/images/second.png" style="margin-top: 50px;"/>
	
	</div>
	
	<div class="contentright">
			<form>
				<div class="field" style="position: relative;">
					&nbsp;&nbsp;<label>请输入密码:</label> <input type="text" name="member.password" id="password" value="${member.password}"> 
					 <i style="width:16px;height: 16px;position: absolute; top:10px; right:20px; background: url('${pageContext.request.contextPath}/public/images/right1.jpg') no-repeat;"></i>
				</div>
				<div  class="field" style="position: relative; border-color: red;">
					&nbsp;&nbsp;<label>&nbsp;&nbsp;&nbsp;&nbsp;确认密码:</label> <input type="text" name="comfirmpassword" id="comfirmpassword"> 
					 <i style="width:16px;height: 16px;position: absolute; top:10px; right:20px; background: url('${pageContext.request.contextPath}/public/images/error.jpg') no-repeat;"></i>
					<div style="position: absolute; height: 20px;width:350px; top:40px; left:0px; line-height: 20px; font-size: 12px; color: red;">
					<img src="${pageContext.request.contextPath}/public/images/errorflag.jpg" style="width:12px; height:12px; vertical-align: middle;" />&nbsp;&nbsp;请输入正确的密码</div>
				</div >
				<div class="field" style="margin-top: 40px">
				
					<a href="#" id="btn_ok" style="display:block; width: 350px; height: 40px; background: #e22 none repeat scroll 0 0; border: 0px; color: white; font-size: 18px; text-align: center;text-decoration: none;">确认</a>
				
				</div>
				
				
			</form>
	
	
	</div>

	
	
	
	</div>
	
	<div class="foot">
	<p></p>
	<p></p>
	<p></p>
		<p>Copyright©2004-2016  京东JD.com 版权所有 </p>
	
	</div>


</div>




</body>
</html>