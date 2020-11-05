package com.axt.dao;

import java.util.List;
import java.util.Map;

public interface GenericDAO {
	
	 public List<Map<String,Object>> qureyForList(String sql,Object... args);   

	

}
