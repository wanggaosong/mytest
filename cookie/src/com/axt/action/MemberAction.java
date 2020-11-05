package com.axt.action;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssi.base.exception.VersionException;

import com.axt.action.base.BaseAction;
import com.axt.service.IMemberService;
import com.axt.util.StringUtil;
import com.axt.util.ValidateImage;
import com.axt.vo.Member;




@Controller
@RequestMapping("/member")
public class MemberAction extends BaseAction {

	@Autowired
	private  IMemberService memberService;	
	
	static Logger logger = Logger.getLogger(MemberAction.class);
	
	@RequestMapping(value="/findPassword")
	public String findPassword(HttpServletRequest request,HttpServletResponse response){
			return "findpassword";
	}
	
	/*@RequestMapping(value="/getPhonevalidatecode")
	public void getPhonevalidatecode(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		String phone = request.getParameter("phone");
		String username = null;
		//需要username
		
		result.put("username",username);
		Member member = memberService.findUnique(result);
				
	}*/

	@RequestMapping(value="/findPasswdsecond")
	public String findPasswdsecond(HttpServletRequest request,HttpServletResponse response){
			return "findpasswordsecond";
	}
	
	@RequestMapping(value="/UpdatePassword")
	public void UpdatePassword(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String,Object>();
		Member member = formMember(request);
		try {
			 Map<String,Object> parmas = new HashMap<String,Object>();
			 parmas.put("phone", member.getPhone());
			 
			 Member tempmember = memberService.findUnique(parmas);
			 
			 tempmember.copyValue(member);
			 
			 try {
				memberService.update(tempmember);
			} catch (VersionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result.put("state", "1");
			result.put("message", "更新失败");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);
			return;
		}
		result.put("state", "0");
		result.put("message", "更新失败");
		String dataString = this.getJsonFromMap(result);
		out(request, response, dataString);
		
		
	}
	
	@RequestMapping(value="/findPasswdthird")
	public String findPasswdthird(HttpServletRequest request,HttpServletResponse response){
			return "findpasswordthird";
	}
	
	@RequestMapping(value="/image")
	public void image(HttpServletRequest request, HttpServletResponse response){
		response.setHeader("Cache-Control", "no-cache");
		//response.setDateHeader("Expires", 0);
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpg");
		ServletOutputStream os;
		try {
			os = response.getOutputStream();
			ImageIO.write((RenderedImage) ValidateImage.getInstance().drawValidateImage(), "JPEG", os);
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		//return "manage/image";
	}
	
	@RequestMapping(value="/toLogin")
	public String toLogin(HttpServletRequest request,HttpServletResponse response){
			return "login";
	}
	
	@RequestMapping(value="/login")
	public void login(HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkNumber = request.getParameter("checkNumber");
		String idCode =request.getParameter("idCode");
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		
		if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password)){
			result.put("state", "1");
			result.put("message", "用户名或密码不能为空^~~^");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);
			return ;
		}
		
	/*	if(!this.checkCode(request, checkNumber, idCode)){
			result.put("state", "1");
			result.put("message", "验证码不正确");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);
			return ;
		}*/
		
		Map<String, Object> userMap = new HashMap<String, Object>();
		userMap.put("username", username.trim());
		userMap.put("password", password.trim());
		
		Member user = null;
		try {
			user = memberService.findUnique(userMap);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getMessage(), e);
			
		}
		if(user == null){
			result.put("state", "1");
			result.put("message", "你输入的用户名或密码不正确^~~^");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);			
		}
		else{
			//String uuid = UUID.randomUUID().toString();
			
			
			result.put("state", "0");
			result.put("message", "登陆成功");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);
		}
			
	}
	
	@RequestMapping(value="/goToFindPassword")
	public String goToFindPassword(HttpServletRequest request,HttpServletResponse response){
		String phone =request.getParameter("phone");
		if(StringUtil.isEmpty(phone)){
			return null;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("phone", phone);
		Member member = new Member();
		try{
			member = memberService.findUnique(map);
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		request.setAttribute("member", member);
		return "findpasswordsecond";
	}
	
	@RequestMapping(value="/compareUsername")
	public void CompareUsername(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		String username = request.getParameter("username");
		//find the username member
		map.put("username", username);
		Member member = new Member();
		member = memberService.findUnique(map);
		Map<String, Object> result = new HashMap<String,Object>();
		if(member==null){
			result.put("data", "1");
			result.put("message", "你输入的用户名正确~~");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);
		}
		result.put("data", "0");
		result.put("message", "你输入的用户名已存在,请重新输入~~");
		String dataString = this.getJsonFromMap(result);
		out(request, response, dataString);
	}
	
	private Member formMember(HttpServletRequest request){
		Member vo = new Member();
		
     
			    	    	    
		String  userid = request.getParameter("member.userid");
	    	    	    	    
		String  username = request.getParameter("member.username");
	    	    	    	    
		String  phone = request.getParameter("member.phone");
	    	    	    	    
		String  email = request.getParameter("member.email");
	    	    	    	    
		String  password = request.getParameter("member.password");
	    	    	    	    
		String  invitecode = request.getParameter("member.invitecode");
	    	    	    	    
		String  flag = request.getParameter("member.flag");
	    	    	    	    
		if(!StringUtil.isEmpty(userid)){
			vo.setUserid(Long.valueOf(userid));
		}
		
		if(!StringUtil.isEmpty(username)){
			vo.setUsername(username);
		}
			
		if(!StringUtil.isEmpty(phone)){
			vo.setPhone(phone);
		}
		
		if(!StringUtil.isEmpty(email)){
			vo.setEmail(email);
		}
		
		if(!StringUtil.isEmpty(password)){
			vo.setPassword(password);
		}
		

    	    
	    return vo;
	}
	
		
}
