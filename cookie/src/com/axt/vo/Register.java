package com.axt.vo;
import java.io.Serializable;
import ssi.base.entity.BaseEntiey;
import java.text.SimpleDateFormat;
import com.axt.util.StringUtil;

public class Register extends BaseEntiey implements Serializable{  
			    	    	    	    
		private java.lang.Long userid;
	    	    	    	    
		private java.lang.String username;
	    	    	    	       	    	    	    
		private java.lang.String password;
		
		private java.lang.String confirmpassword;
	    	    	    	    
		private java.lang.String phone;
	    	    	    	    
		private java.lang.String email;
	    	    	    	    
		private java.lang.String phonevalidatecode;
	    	    	    	    
		private java.lang.String invitecode;
	    	    	    	    
		private java.lang.String unicodeflag;
	    	    	    	    
	    			    	    	    
		public java.lang.Long getUserid(){
			return userid;
		}
		 
		public void setUserid(java.lang.Long userd){
        	this.userid=userid;
		}  
	    	    	    	    
		public java.lang.String getUsername(){
			return username;
		}
		
		public void setUsername(java.lang.String username){
			this.username = username;
		}
	    	
		public java.lang.String getPassword(){
			return password;
		}
		
		public void setPassword(java.lang.String password){
			this.password = password;
		}
		
		public java.lang.String getConfirmpassword(){
			return confirmpassword;
		}
		
		public void setConfirmpassword(java.lang.String confirmpassword){
			this.confirmpassword = confirmpassword;
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
		
		public java.lang.String getPhonevalidatecode(){
			return phonevalidatecode;
		}
		
		public void setPhonevalidatecode(java.lang.String phonevalidatecode){
			this.phonevalidatecode = phonevalidatecode;
		}
		
		public java.lang.String getInvitecode(){
			return invitecode;
		}
		
		public void setInvitecode(java.lang.String invitecode){
			this.invitecode = invitecode;
		}
		
		public java.lang.String getUnicodeflag(){
			return unicodeflag;
		}
		
		public void setUnicodeflag(java.lang.String unicodeflag){
			this.unicodeflag = unicodeflag;
		}
		
    	@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void updateVo(BaseEntiey vo) {
			// TODO Auto-generated method stub
			
		}  
		
		public void copyValue( Register vo){
			    		    
			if(!StringUtil.isEmpty(vo.getUserid())){
				this.setUserid(vo.getUserid());
			}				  
		    		    
			if(!StringUtil.isEmpty(vo.getUsername())){
				this.setUsername(vo.getUsername());
			}
			
			if(!StringUtil.isEmpty(vo.getPassword())){
				this.setPassword(vo.getPassword());
			}
			
			if(!StringUtil.isEmpty(vo.getConfirmpassword())){
				this.setConfirmpassword(vo.getConfirmpassword());
			}
			
			if(!StringUtil.isEmpty(vo.getPhone())){
				this.setPhone(vo.getPhone());
			}
			
			if(!StringUtil.isEmpty(vo.getEmail())){
				this.setEmail(vo.getEmail());
			}
			
			if(!StringUtil.isEmpty(vo.getPhonevalidatecode())){
				this.setPhonevalidatecode(vo.getPhonevalidatecode());
			}
		    		  
		    if(!StringUtil.isEmpty(vo.getInvitecode())){
		    	this.setInvitecode(vo.getInvitecode());
		    }		    
			
			if(!StringUtil.isEmpty(vo.getUnicodeflag())){
				this.setUnicodeflag(vo.getUnicodeflag());
			}
		    			
		
			
		}

	    
}  