package com.spaceeye.dao;

import java.util.HashMap;
import java.util.List;

import com.spaceeye.dto.Databable;

public interface IDatabableDao {
	
	public void saveDatabable(Databable databable);
	
	public void findDatabableList();
	
	 int selectCount();
	 
	   // 分页操作，调用findByPage limit分页方法
     List<Databable> findByPage(HashMap<String,Object> map);
     

     
     

}
