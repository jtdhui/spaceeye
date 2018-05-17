package com.spaceeye.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceeye.dao.ISatelliteDao;
import com.spaceeye.dto.PageBean;
import com.spaceeye.dto.Satellite;
import com.spaceeye.service.ISatelliteService;

@Service
public class SatelliteService implements ISatelliteService {
	
	@Autowired
	private ISatelliteDao satelliteDao;

	@Override
	public List<Satellite> findSatelliteList() {		
		List<Satellite> satelliteList=satelliteDao.findSatelliteList();
		return satelliteList;
	}

	@Override
	public void saveSatellite(String sqlFile) {	
			try{    
				List<String> ids=satelliteDao.findSatelliteIds();
				 //连接SQLite的JDBC  
				Class.forName("org.sqlite.JDBC");  
				//建立一个数据库名satinfo.db的连接，如果不存在就在当前目录下创建之  
				String sqlConnection="jdbc:sqlite:"+sqlFile;
				Connection conn =DriverManager.getConnection(sqlConnection);  
				Statement stat = conn.createStatement();  
				ResultSet rs = stat.executeQuery("select * from satcat");//查询数据  
				if(ids==null){
					while(rs.next()){//将查询到的数据打印出来
						Satellite saveSatellite=new Satellite();
						saveSatellite.setSatelliteId(Integer.parseInt(rs.getString("S_BHAO")));
						saveSatellite.setSatelliteName(rs.getString("S_NAME"));
						satelliteDao.saveSatellite(saveSatellite);
					    System.out.print("S_BHAO = "+ rs.getString("S_BHAO")+" ");//列属性一  
					    System.out.println("S_NAME = "+ rs.getString("S_NAME"));//列属性二  
					}  
				}else{					
					while(rs.next()){
						if(!ids.contains(rs.getString("S_BHAO"))){
							Satellite saveSatellite=new Satellite();
							saveSatellite.setSatelliteId(Integer.parseInt(rs.getString("S_BHAO")));
							saveSatellite.setSatelliteName(rs.getString("S_NAME"));
							satelliteDao.saveSatellite(saveSatellite);
						}
						
					}  
					
				}
					   rs.close();  
					   conn.close();//结束数据库的连接  
				}  
				catch(Exception e ){  
				   e.printStackTrace(); 
				}

			}

	@Override
	public List<String> findSatelliteLikeBhao(String bhao) {
		 List<String> names=new ArrayList<String>();
		 List<Satellite> satelliteList=satelliteDao.findSatelliteLikeBhao(bhao);
		 for(Satellite satellite:satelliteList){
			 String bhaoName=satellite.getSatelliteId()+"-"+satellite.getSatelliteName();
			 names.add(bhaoName);
		 }
		return names;
	}

	@Override
	public int updateByPrimaryKey(Satellite satellite) {
		// TODO Auto-generated method stub
		return satelliteDao.updateByPrimaryKey(satellite);
	}

	@Override
	public PageBean<Satellite> findByPage(int currentPage, int pageSize,
			Satellite satellite) {
		   HashMap<String,Object> map = new HashMap<String,Object>();
	        PageBean<Satellite> pageBean = new PageBean<Satellite>();
	        //封装当前页数
	        pageBean.setCurrPage(currentPage);
	        //每页显示的数据
	        pageBean.setPageSize(pageSize);
	        //封装总记录数
	        int totalCount = satelliteDao.selectCount();
	        pageBean.setTotalCount(totalCount);
	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean.setTotalPage(num.intValue());
	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        //封装每页显示的数据
	        List<Satellite> lists = satelliteDao.findByPage(map);
	        pageBean.setLists(lists);

	        return pageBean;
	}

	@Override
	public Satellite selectByPrimaryKey(Integer satelliteId) {
		// TODO Auto-generated method stub
		return satelliteDao.selectByPrimaryKey(satelliteId);
	}

	}

