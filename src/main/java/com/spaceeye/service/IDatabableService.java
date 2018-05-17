package com.spaceeye.service;

import com.spaceeye.dto.Databable;
import com.spaceeye.dto.PageBean;

public interface IDatabableService {
	
     public void saveDatabable(Databable databable);
     
     PageBean<Databable> findByPage(int currentPage,int pageSize);
}
