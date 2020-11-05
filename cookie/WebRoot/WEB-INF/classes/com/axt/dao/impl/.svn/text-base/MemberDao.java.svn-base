package com.axt.dao.impl;
import ssi.base.dao.impl.GenericDao;
import com.axt.vo.Member;
import com.axt.dao.IMemberDao;

/**
 * Dao实现.应用设备
 * @author 资产管理
 */
public class MemberDao  extends GenericDao<Member> implements IMemberDao{
	public void delSelectAll(String str) {
		getSqlMapClientTemplate().delete("Member.delSelectAll", str);
	}
}