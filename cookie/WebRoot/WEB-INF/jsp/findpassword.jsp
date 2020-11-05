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
	
		var InterValObj; 	//timer变量，控制时间  
		var count = 10; 	//间隔函数，1秒执行  
		var curCount;
		
		function checkNumberImage() {
			var imageNumber = document.getElementById("wgs");
			imageNumber.src = "${pageContext.request.contextPath}/member/image.do?idcode=${uuid}";
		}
		
		function SetRemainTime() {  
		    if (curCount == 0) {                  
		        window.clearInterval(InterValObj);//停止计时器  
		        $("#btn_image").removeAttr("disabled");//启用按钮  
		        $("#btn_image").val("重新发送验证码");  
		        code = ""; //清除验证码。如果不清除，过时间后，输入收到的验证码依然有效      
		    }   else {  
		        curCount--;  
		        $("#btn_image").val("请在" + curCount + "秒内输入验证码");  
		    }  
		} 
		
		$(document).ready(function(){
			var isEmpty = true;
			$("#phone").focusout(function(){
				var phonenumber = $.trim($("#phone").val());
				var reg = /^0?1[3|4|5|8][0-9]\d{8}$/;
				if(phone == null || phone == ""){
					alert("*手机号不能为空~^~");
					isEmpty= false;
				}else if(!reg.test(phone))  {
		            alert('请输入有效的手机号码！');
		            isEmpty= false;
		        }else{
					isEmpty = true;
				}
			});
			
			$("#btn_image").click(function(){
				$("#phone").trigger("focusout"); 
				if(!isEmpty){
					return false;
				}
				//设置button效果，开始计时  
				curCount = count;  
		        $("#btn_image").attr("disabled", "true");  
		        $("#btn_image").val("请在" + curCount + "秒内输入验证码");  
		        InterValObj = window.setInterval(SetRemainTime, 1000);  
			 	var form = $("#myform");
				$.ajax({
						 type: "POST",
						 url: "${pageContext.request.contextPath}/register/generatecode.do?rnd=" + Math.random(),
						 contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
						 cache:false,
						 dataType : "json",
						 data: $(form).serialize(),
						 success: function(data){
			 				alert(data.message);
						 }
				 });                
			});
			
			$("#btn_ok").click(function(){
				alert(1);
				$("phone").trigger("focusout");
				if(!isEmpty){
					return false;
				}
				var form = $("#myform");
				var phone = $("#phone").val();
				location.href="${pageContext.request.contextPath}/member/goToFindPassword.do?phone="+phone;
			
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

<div class="findpasswd">

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
	
		<img src="${pageContext.request.contextPath}/public/images/firststep.png" style="margin-top: 50px;"/>
	
	</div>
	
	<div class="contentright">
			<form>
				<div class="field" style="position: relative;">
					&nbsp;&nbsp;<label>请输入绑定的手机号:</label> <input type="text" name="phone" id="phone"> 
					 <i style="width:16px;height: 16px;position: absolute; top:10px; right:20px; background: url('${pageContext.request.contextPath}/public/images/right1.jpg') no-repeat;"></i>
				</div>
				
			    <div  class="field">
					&nbsp;&nbsp;<label>手机验证码:</label> <input type="text" name="checkcode" id="checkcode"> <button id="btn_image" style="width:111px; height:40px; background-color:  #C0C0C0; border: 0px; vertical-align: top;">获取验证码</button>  <br/>
				</div>
			
				<div  class="field" style="position: relative; border-color: red;">
					&nbsp;&nbsp;<label>验&nbsp;&nbsp;证&nbsp;&nbsp;码:</label> <input type="text" name="checkNumber" id="checkNumber" style="width:150px;" >  <img id="wgs" src="${pageContext.request.contextPath}/member/image.do?idcode=${uuid}" width="113px;" border="0px;" height="40px;" onclick="checkNumberImage();" style="vertical-align: top; "/>
					<div style="position: absolute; height: 20px;width:350px; top:40px; left:0px; line-height: 20px; font-size: 12px; color: red;">
					<img src="${pageContext.request.contextPath}/public/images/errorflag.jpg" style="width:12px; height:12px; vertical-align: middle;" />&nbsp;&nbsp;请输入正确的验证码</div>
				</div>
				
				
				
				<div class="field" style="margin-top: 30px">
				
					<a href="#" id="btn_ok" style=" display:block; width: 350px; height: 40px; background: #e22 none repeat scroll 0 0; border: 0px; color: white; font-size: 18px; text-align: center;  text-decoration: none;">确定</a>
				
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