package com.axt.dao.impl;
import ssi.base.dao.impl.GenericDao;
import com.axt.vo.Register;
import com.axt.dao.IRegisterDao;

/**
 * Dao实现.应用设备
 * @author 资产管理
 */
public class RegisterDao  extends GenericDao<Register> implements IRegisterDao{
	public void delSelectAll(String str) {
		getSqlMapClientTemplate().delete("Register.delSelectAll", str);
	}
}