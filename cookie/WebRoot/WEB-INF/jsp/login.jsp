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
		function checkNumberImage() {
			var imageNumber = document.getElementById("wgs");
			imageNumber.src = "${pageContext.request.contextPath}/member/image.do?idcode=${uuid}";
		}
		$(document).ready(function(){
		
			//alert(222);
			var isEmpty = true;
			$("#username").focusout(function(){
				var username = $.trim($("#username").val());
				if(username == null || username == ""){
					alert("*用户名不能为空~^~");
					isEmpty= false;
		        }else{
					isEmpty = true;
				}
			});
			$("#password").focusout(function(){
				var password = $.trim($("#password").val());
				if(password == null || password == ""){
					alert("*密码不能为空~^~");
					isEmpty= false;
		        }else{
					isEmpty = true;
				}
			});

			$("#btn_ok").click(function(event){
				event.preventDefault();
				//添加时判断是否必填项是否为空
				$("#username").trigger("focusout"); 
				$("#password").trigger("focusout"); 
				if(!isEmpty){
					return false;
				}
			 	var form = $("#myform");
			
				$.ajax({
						 type: "POST",
						 url: "${pageContext.request.contextPath}/member/login.do",
						 contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
						 cache:false,
						 dataType : "json",
						 data: $(form).serialize(),
						 success: function(data){
			 				alert(data.message);
							if(data.state == 0){
								return false;
					 		}
						 }
				 });              
				
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

<div class="login">

	<div class="nav" style="position: relative;">
		<div style="float: left;">
			<img src="${pageContext.request.contextPath}/public/images/logo.png" style="width:60px;height: 60px; vertical-align: top; margin-top: 20px;margin-left: 30px;"  />
		</div>
	
		<div style="width:110px;height: 50px;line-height: 50px; border-left: 1px solid #F0F0F0; font-size: 18px;font-weight: bolder;display:block; position: absolute; top:25px; left:120px;">
			
			欢迎登录
		
		</div>
		
	</div>
	
	<div class="content">
	
	
	<div class="contentright">
			<form  id="myform">
				<div class="field" style="position: relative;">
					&nbsp;&nbsp;<label>用&nbsp;&nbsp;户&nbsp;&nbsp;名:</label> <input type="text" name="username" id="username"> 
					 <i style="width:16px;height: 16px;position: absolute; top:10px; right:20px; background: url('${pageContext.request.contextPath}/public/images/right1.jpg') no-repeat;"></i>
				</div>
				
				<div  class="field" style="position: relative; border-color: red;">
					&nbsp;&nbsp;<label>&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label> <input type="text" name=password id="password"> 
					 <i style="width:16px;height: 16px;position: absolute; top:10px; right:20px; background: url('${pageContext.request.contextPath}/public/images/error.jpg') no-repeat;"></i>
					<div style="position: absolute; height: 20px;width:350px; top:40px; left:0px; line-height: 20px; font-size: 12px; color: red;">
					<img src="${pageContext.request.contextPath}/public/images/errorflag.jpg" style="width:12px; height:12px; vertical-align: middle;" />&nbsp;&nbsp;请输入正确的密码</div>
				</div >
			
				<div  class="field" style="position: relative; border-color: red;">
					&nbsp;&nbsp;<label>验&nbsp;&nbsp;证&nbsp;&nbsp;码:</label> <input type="text" name="checkNuber" id="checkNumber" style="width:150px;" > 
					<img id="wgs" src="${pageContext.request.contextPath}/member/image.do?idcode=${uuid}" onclick="checkNumberImage();" width="113px;" border="0px;" height="40px;"  style="vertical-align: top; "/>
					<div style="position: absolute; height: 20px;width:350px; top:40px; left:0px; line-height: 20px; font-size: 12px; color: red;">
					<img src="${pageContext.request.contextPath}/public/images/errorflag.jpg" style="width:12px; height:12px; vertical-align: middle;" />&nbsp;&nbsp;请输入正确的验证码</div>
				</div>
				
				
				
				<div class="field" style="margin-top: 30px">
				
					<button id="btn_ok" style=" width: 350px; height: 40px; background: #e22 none repeat scroll 0 0; border: 0px; color: white; font-size: 18px;">登&nbsp;&nbsp;录</button>
				
				</div>
				
				<div  class="field" style="position: relative; border:0px; background:  	#F8F8F8 no-repeat;">
				
					<a href="${pageContext.request.contextPath}/member/findPassword.do" style="display: block; width:80px; height:40px;  float: left; color: red; margin-left: 30px;">忘记密码？</a> 
					<a href="${pageContext.request.contextPath}/register/goToSaveRegister.do" style="display: block; width:80px; height:40px;  float: right; color: red;">立即注册</a>
					
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