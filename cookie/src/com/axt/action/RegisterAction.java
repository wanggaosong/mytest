package com.axt.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ssi.base.exception.VersionException;

import com.axt.action.base.BaseAction;
import com.axt.service.IRegisterService;
import com.axt.vo.Register;

@Controller
@RequestMapping("/register")
public class RegisterAction extends BaseAction {
	
	@Autowired
	private  IRegisterService registerService;
	
	@RequestMapping(value="/goToSaveRegister")
	public String goToSaveRegisterPage(HttpServletRequest request,HttpServletResponse response){
			return "register";
	}
	
	@RequestMapping(value="/registerSave")
	public void RegisterSave(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> result = new HashMap<String,Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		Register register = new Register();
		register.setUsername(username);
		register.setPassword(password);
		register.setPhone(phone);
		register.setEmail(email);
		
		registerService.saveOfmember(register);
		/*try {
			Map<String, Object> map = new HashMap<String,Object>();
			
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
		result.put("state","0");
		result.put("message","注册成功");
		String dataString = this.getJsonFromMap(result);
		out(request, response, dataString);
		
	}
	
	@RequestMapping(value="/generatecode")
	public void generatecode(HttpServletRequest request, HttpServletResponse response){
		Map<String, Object> result = new HashMap<String, Object>();
		String phone = request.getParameter("phone");
		Register register = new Register();
		register.setPhone(phone);
		
		String phonevalidatecode = "1234";
		register.setPhonevalidatecode(phonevalidatecode);
		try {
			registerService.save(register);
			result.put("state", "0");
			result.put("message", "手机验证码已发送");
			String dataString = this.getJsonFromMap(result);
			out(request, response, dataString);
		} catch (VersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("phone", register.getPhone());
			Register register2 = registerService.findUnique(map);
			if(register2 != null){
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
	
	
}