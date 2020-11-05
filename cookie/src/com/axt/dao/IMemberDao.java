package com.axt.dao;
import ssi.base.dao.IGenericDao;
import  com.axt.vo.Member;
public interface IMemberDao  extends IGenericDao<Member>{

	void delSelectAll(String str);
	
}