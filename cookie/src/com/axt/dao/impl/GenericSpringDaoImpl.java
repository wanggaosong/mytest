package com.axt.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.axt.dao.GenericDAO;

public class GenericSpringDaoImpl extends JdbcDaoSupport implements GenericDAO {
	
	public List<Map<String, Object>> qureyForList(String sql, Object... args) {
		   return getJdbcTemplate().queryForList(sql, args);
	}

}
