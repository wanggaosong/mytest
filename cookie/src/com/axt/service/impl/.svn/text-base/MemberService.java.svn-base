package com.axt.service.impl;

import ssi.base.exception.VersionException;
import org.springframework.stereotype.Service;
import ssi.base.service.impl.BaseService;
import com.axt.dao.IMemberDao;
import com.axt.service.IMemberService;
import com.axt.vo.Member;

public class MemberService extends BaseService<Member> implements IMemberService {

		public void deleteAll(String str) throws VersionException {
			((IMemberDao)(this.getDefaultDao())).delSelectAll(str);
	    }
	
}