package com.axt.vo;
import java.io.Serializable;
import ssi.base.entity.BaseEntiey;
import java.text.SimpleDateFormat;
import com.axt.util.StringUtil;

public class Member extends BaseEntiey implements Serializable{  
		
		public java.lang.Long userid;
		
		public java.lang.String username;
		
		public java.lang.String phone;
		
		public java.lang.String email;
	    
		public java.lang.String password;
		
		public java.lang.String invitecode;
		
		public java.lang.String flag;
		
		public java.lang.Long getUserid(){
			return userid;
		}
		
		public void setUserid(java.lang.Long userid){
			this.userid = userid;
		}
		
		public java.lang.String getUsername(){
			return username;
		}
		
		public void setUsername(java.lang.String username){
			this.username = username;
		}
		
		public java.lang.String getPhone(){
			return phone;
		}
		
		public void setPhone(java.lang.String phone){
			this.phone = phone;
		}
		
		public java.lang.String getEmail(){
			return email;
		}
		
		public void setEmail(java.lang.String email){
			this.email = email;
		}
		
		public java.lang.String getPassword(){
			return password;
		}
		
		public void setPassword(java.lang.String password){
			this.password = password;
		}
		
		public java.lang.String getInvitecode(){
			return invitecode;
		}
		
		public void setInvitecode(java.lang.String invitecode){
			this.invitecode = invitecode;
		}
		
		public java.lang.String getFlag(){
			return flag;
		}
		
		public void setFlag(java.lang.String flag){
			this.flag = flag;
		}
		
    	@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateVo(BaseEntiey vo) {
			// TODO Auto-generated method stub
			
		}  
		
		public void copyValue( Member vo){
		
					  		    		    
			if(!StringUtil.isEmpty(vo.getUserid())){
				this.setUserid(vo.getUserid());
			}
			
			if(!StringUtil.isEmpty(vo.getUsername())){
				this.setUsername(vo.getUsername());
			}
			
			if(!StringUtil.isEmpty(vo.getPhone())){
				this.setPhone(vo.getPhone());
			}
			
			if(!StringUtil.isEmpty(vo.getEmail())){
				this.setEmail(vo.getEmail());
			}
			
			if(!StringUtil.isEmpty(vo.getPassword())){
				this.setPassword(vo.getPassword());
			}
			
			if(!StringUtil.isEmpty(vo.getInvitecode())){
				this.setInvitecode(vo.getInvitecode());
			}
			
			if(!StringUtil.isEmpty(vo.getFlag())){
				this.setFlag(vo.getFlag());
			}
		}
	    
}  