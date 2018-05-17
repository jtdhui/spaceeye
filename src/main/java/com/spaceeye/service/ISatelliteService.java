package com.spaceeye.service;
import java.util.List;

import com.spaceeye.dto.PageBean;
import com.spaceeye.dto.Satellite;

public interface ISatelliteService {
	//查询所有对的卫星
	public List<Satellite> findSatelliteList();
	
	//保存卫星信息
	public void saveSatellite(String sqlFile);
	
	//按编号模糊查询卫星
	public List<String> findSatelliteLikeBhao(String bhao);
	
    //按主键修改
	public int updateByPrimaryKey(Satellite satellite);
	
	//分页查询
	PageBean<Satellite> findByPage(int currentPage,int pageSize,Satellite satellite);
	
	//卫星详情查看
	Satellite  selectByPrimaryKey(Integer satelliteId);

}
