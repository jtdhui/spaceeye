package com.spaceeye.service.impl;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceeye.dao.IDatabableDao;
import com.spaceeye.dto.Article;
import com.spaceeye.dto.Databable;
import com.spaceeye.dto.PageBean;
import com.spaceeye.service.IDatabableService;

@Service
public class DatabableService implements IDatabableService{
	
	@Autowired
	private IDatabableDao databableDao;
	@Override
	public void saveDatabable(Databable databable) {
		
		databableDao.saveDatabable(databable);
	}
	@Override
	public PageBean<Databable> findByPage(int currentPage,int pageSize) {
		    HashMap<String,Object> map = new HashMap<String,Object>();
	        PageBean<Databable> pageBean = new PageBean<Databable>();

	        //封装当前页数
	        pageBean.setCurrPage(currentPage);

	        //每页显示的数据
	        pageBean.setPageSize(pageSize);

	        //封装总记录数
	        int totalCount = databableDao.selectCount();
	        pageBean.setTotalCount(totalCount);

	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean.setTotalPage(num.intValue());

	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        //封装每页显示的数据
	        List<Databable> lists = databableDao.findByPage(map);
	        pageBean.setLists(lists);

	        return pageBean;
	}

}
