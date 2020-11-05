package com.axt.action.base;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import ssi.base.util.StringUtil;


import com.axt.passport.PassPort;
import com.axt.sso.client.helper.SSOHelper;
import com.axt.sso.client.memCached.MemCached;
import com.axt.util.ValidateImage;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class BaseAction   implements Serializable{
	
	protected static String serverAddress = "f75b0281bd742342aad706b339698bcc" ;
	
    public static final String MESSAGE_PAGE = "message";
	public static final String MESSAGE = "message";
	public static final String UPLOAD_SAVEURL_LINUX = "/home/cookie/";
	public static final String UPLOAD_VIEWURL_LINUX = "http://115.28.50.39:8080/cookie/";
	public static final String UPLOAD_SAVEURL_WINDOW = "D:\\workspace\\cookie\\WebRoot\\resource\\";
	public static final String UPLOAD_VIEWURL_WINDOW = "http://192.168.1.113:8080/cookie/resource/";
	
	public static final String UPLOAD_File_WINDOW = "D:\\workspace\\cookie\\WebRoot\\upload\\";
	public static final String UPLOAD_File_LINUX= "/home/bjaxt/www.bjiguacu.com/cookie/upload/";
	
	static Logger logger = Logger.getLogger(BaseAction.class);
	/**
	 * 获取请求ip地址。
	 * 
	 * @param request
	 * @return
	 */
	public String getRemoteAdd(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.trim();
	}

	/**
	 * 获取绝对uri根地址。
	 * 
	 * @param request
	 * @return
	 */
	public String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	/**
	 * 添加coockie值。
	 * 
	 * @param name
	 *            名称
	 * @param value
	 *          值
	 * @param expiry
	 *            生命周期 ,本次会话
	 * @param path
	 *            路径 默认根路径
	 * 
	 */
	public static void setCookie(String name, String value, Integer expiry,
			String path, HttpServletResponse response) {
		if (StringUtil.isEmpty(name) || StringUtil.isEmpty(value)) {
			return;
		}

		Cookie c = new Cookie(name, value);
		// 设置Cookie路径和域名
		if (StringUtil.isEmpty(path)) {
			path = "/";
		}
		if (expiry != null) {
			c.setMaxAge(expiry);
		}
		c.setPath(path);
		c.setDomain(".bjaxt.com");//m.pay.51play.com
		response.addCookie(c);
	}

	/**
	 * 获取Coockie值
	 * 
	 * @param name
	 * @param request
	 * @return
	 */
	public String getCookieVal(String name, HttpServletRequest request) {
		if (StringUtil.isEmpty(name)) {
			return null;
		}
		Cookie[] cookies = request.getCookies();
		if(cookies == null){
			return null;
		}
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				return c.getValue();
			}
		}
		return null;
	}

	/**
	 * 删除Coockie值
	 * 
	 * @param name
	 * @param request
	 * @param response
	 */
	public void delCoockie(String name, HttpServletRequest request,
			HttpServletResponse response) {
		if (StringUtil.isEmpty(name)) {
			return;
		}
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				c.setMaxAge(0);
				response.addCookie(c);
				return;
			}
		}
	}

	/**
	 * 更新coockie值
	 * 
	 * @param name
	 * @param value
	 * @param request
	 * @param response
	 */
	public void updateCoockie(String name, String value,
			HttpServletRequest request, HttpServletResponse response) {
		if (StringUtil.isEmpty(name) || StringUtil.isEmpty(value)) {
			return;
		}
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				c.setValue(value);
				response.addCookie(c);
				return;
			}
		}
	}
	
	public  String getJsonFromMap(Map<String,Object> map){
		JSONObject json = JSONObject.fromObject(map); 
		return json.toString();
	}
	
	public String getJsonFromList(List<Map<String,Object>> list){
		return JSONArray.fromObject(list).toString();
	}
	
	public String getJsonFromObject(Object object){
		return JSONObject.fromObject(object).toString();
	}
	
	public boolean checkCode(HttpServletRequest request,String code,String idcode){
		String checkSessonCode =  (String)MemCached.get(idcode);
	//	ValidateImage.getInstance().drawValidateImage(idcode);
		if(code == null || checkSessonCode == null){
			return false;
		}
		if(code.trim().equalsIgnoreCase(checkSessonCode.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * 获取当前登录用户名
	 * @param request
	 * @return
	 */
	public PassPort getPassport(HttpServletRequest request){
        return (PassPort)request.getAttribute(SSOHelper.REMOTE_USER);
    }
	
	public static void out(HttpServletRequest request,HttpServletResponse response,String dataString){
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(dataString);
			out.flush();
			out.close();
		} catch (IOException e) {
			System.out.print("获取json相关数据报错"+e.getMessage());
		}
	}

	/**
	 * 去除html标签
	 * @param htmlStr
	 * @return
	 */
	public static String delHTMLTag(String htmlStr){ 
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式 
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式 
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式 
        
        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
        Matcher m_script=p_script.matcher(htmlStr); 
        htmlStr=m_script.replaceAll(""); //过滤script标签 
        
        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
        Matcher m_style=p_style.matcher(htmlStr); 
        htmlStr=m_style.replaceAll(""); //过滤style标签 
        
        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
        Matcher m_html=p_html.matcher(htmlStr); 
        htmlStr=m_html.replaceAll(""); //过滤html标签 

       return htmlStr.trim(); //返回文本字符串 
    } 
	
	
	public  String getCorrectName(String str){
		String newStr = null;
		str = str.replace(" ", "");
		str = str.replace(" ","");
		str = str.replace("）", "");
		str = str.replace("（", "");
		try {
			newStr = java.net.URLEncoder.encode(str,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return newStr;
	}
	
	protected void downLoadFile(String filePath,String downloadName,HttpServletRequest request,HttpServletResponse response){
		String ext = filePath.substring(filePath.lastIndexOf("."));
		String agent = (String)request.getHeader("USER-AGENT");
		if(agent != null && agent.toLowerCase().indexOf("firefox") != -1) {
			String enableFileName = "";
			try {
				enableFileName = "=?UTF-8?B?" + (new String(Base64.encode((downloadName).getBytes("UTF-8")))) + "?=";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
			response.setHeader("Content-Disposition", "attachment; filename=\"" + (enableFileName + ext)  + "\"");  
		}else{
			response.setHeader("Content-Disposition", "attachment; filename=\"" 	+this.getCorrectName(downloadName + ext)  + "\"");
		}
		BufferedInputStream bis = null;
		OutputStream sos = null; 
		// 设置响应头和保存文件名
		//response.setContentType("APPLICATION/OCTET-STREAM");
		
		//response.setCharacterEncoding("ISO8859_1");
		try {
			bis = new BufferedInputStream(new FileInputStream(filePath));
			sos = response.getOutputStream();
			int len = 0;
			while((len=bis.read())!=-1){
				sos.write(len);
			}
			bis.close();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
