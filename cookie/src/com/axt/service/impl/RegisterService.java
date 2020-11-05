package com.axt.service.impl;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import ssi.base.exception.VersionException;
import org.springframework.stereotype.Service;
import ssi.base.service.impl.BaseService;

import com.axt.dao.IMemberDao;
import com.axt.dao.IRegisterDao;
import com.axt.dao.impl.RegisterDao;
import com.axt.service.IRegisterService;
import com.axt.vo.Member;
import com.axt.vo.Register;

public class RegisterService extends BaseService<Register> implements IRegisterService {

		public IMemberDao memberDao;
	
		public void deleteAll(String str) throws VersionException {
			((IRegisterDao)(this.getDefaultDao())).delSelectAll(str);
	    }
		
		
		public void saveOfmember(Register request) {
			try {
				((IRegisterDao)(this.getDefaultDao())).update(request);
				
				Member member = new Member();
				member.setUsername(request.getUsername());
				member.setPassword(request.getPassword());
				member.setPhone(request.getPhone());
				member.setEmail(request.getEmail());
				
				//member.setInvitecode(request.getInvitecode());
				//member.setFlag(request.getUnicodeflag());
				
				memberDao.insert(member);
			} catch (VersionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


		public IMemberDao getMemberDao() {
			return memberDao;
		}


		public void setMemberDao(IMemberDao memberDao) {
			this.memberDao = memberDao;
		}
		
		
	
}