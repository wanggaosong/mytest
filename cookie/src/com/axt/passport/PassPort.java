package com.axt.passport;

import java.io.Serializable;

public class PassPort implements  Serializable {
	
		private long memberid;
		
		private String phoneumber;
		
		
		private String nickname;
		
		
		public long getMemberid() {
			return memberid;
		}


		public void setMemberid(long memberid) {
			this.memberid = memberid;
		}


		public String getPhoneumber() {
			return phoneumber;
		}


		public void setPhoneumber(String phoneumber) {
			this.phoneumber = phoneumber;
		}


		public String getNickname() {
			return nickname;
		}


		public void setNickname(String nickname) {
			this.nickname = nickname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		private String email;
		
		

}
