package com.spaceeye.dao;

import java.util.HashMap;
import java.util.List;

import com.spaceeye.dto.Satellite;

public interface ISatelliteDao {
	
	public List<Satellite> findSatelliteList();
	
	public void saveSatellite(Satellite satellite);
	
	public List<Satellite> findSatelliteLikeBhao(String bhao);
	
	public Satellite findSatelliteByBhao(String bhao);
	
	public int updateByPrimaryKey(Satellite satellite);
	
	public Satellite selectByPrimaryKey(Integer satelliteId);
	
    // 分页操作，调用findByPage limit分页方法
    List<Satellite> findByPage(HashMap<String,Object> map);
    
	//查询总记录数
	int selectCount();

    //清空表数据
    public void truncateTable();
    
    //查询所有的卫星编号
    public List<String> findSatelliteIds();
}
