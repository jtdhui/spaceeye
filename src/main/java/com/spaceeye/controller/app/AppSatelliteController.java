package com.spaceeye.controller.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceeye.dto.Article;
import com.spaceeye.dto.PageBean;
import com.spaceeye.dto.Satellite;
import com.spaceeye.service.IArticleService;
import com.spaceeye.service.ISatelliteService;

@Controller
@RequestMapping("/appSatellite")
public class AppSatelliteController {
	@Autowired
	private ISatelliteService satelliteService;
	
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping(value="/appFindSatelliteList",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> appFindSatelliteList(@RequestBody String data){
		System.out.println("data:"+data);
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(data);
		JSONObject jsonObject2=JSONObject.fromObject(jsonObject.getString("data"));
		String pageNumber=jsonObject2.getString("pageNumber");
		String pageSize=jsonObject2.getString("pageSize");
		try{			
			PageBean<Satellite> satellitePages=satelliteService.findByPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),new Satellite());
			Map<String,Object> findMap=new HashMap<String,Object>();
			List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
			if(null!=satellitePages){
				for(Satellite satellite:satellitePages.getLists()){
					if(null!=satellite.getAppDetail() && ""!=satellite.getAppDetail()){
						findMap.put("id",satellite.getSatelliteId());
						findMap.put("satelliteName",satellite.getSatelliteName());
						findMap.put("editorTime",satellite.getEditorTime());
						mapList.add(findMap);
					}
				}
				map.put("result",mapList);
				map.put("pageNumber",pageNumber);
				map.put("pageSize",pageSize);
				map.put("status", "200");
				map.put("mgs","查询成功");
				return map;
				
			}else{
				map.put("status", "200");
				map.put("mgs","暂无数据");
				return map;
			}
			
		}
		catch(Exception e){
			map.put("status", "400");
			map.put("mgs","查询失败");
			return map;
		}		
		
	}
	
	@RequestMapping(value="/appSatelliteById",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> appSatelliteById(@RequestBody String data){
		System.out.println("data:"+data);
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(data);
		JSONObject jsonObject2=JSONObject.fromObject(jsonObject.getString("data"));
		String satelliteId=jsonObject2.getString("satelliteId");		
		try{
			Satellite satellite=satelliteService.selectByPrimaryKey(Integer.parseInt(satelliteId));
			List<Article> articleList=articleService.findSatelliteByBhao(satelliteId);
			Map<String,Object> findMap=new HashMap<String,Object>();
			Map<String,Object> articleMap=new HashMap<String,Object>();
			List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
			if(null!=satellite){
				findMap.put("id",satellite.getSatelliteId());
				findMap.put("satelliteName",satellite.getSatelliteName());
				findMap.put("appDetail",satellite.getAppDetail());
				if(null!=articleList){			
					for(Article article:articleList){
						articleMap.put("title",article.getTitle());
						articleMap.put("pushTime",article.getPublishTime());
						articleMap.put("appContent",article.getAppContent());
						mapList.add(articleMap);
					}
				}
				findMap.put("articleList",mapList);
				map.put("result",findMap);
				map.put("status", "200");
				map.put("mgs","查询成功");
				return map;
				
			}else{
				map.put("status", "200");
				map.put("mgs","暂无数据");
				return map;
			}
			
		}
		catch(Exception e){
			map.put("status", "400");
			map.put("mgs","查询失败");
			return map;
		}		
		
	}

}
