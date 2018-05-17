package com.spaceeye.controller.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceeye.dto.AppInformation;
import com.spaceeye.dto.Article;
import com.spaceeye.dto.PageBean;
import com.spaceeye.service.IAppInformationService;
import com.spaceeye.service.IArticleService;

@Controller
@RequestMapping("/appArticle")
public class AppArticleController {
	@Autowired
	private IArticleService articleService;
	
	@RequestMapping(value="/appFindArticleList",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> appFindArticleList(@RequestBody String data){
		System.out.println("data:"+data);
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(data);
		JSONObject jsonObject2=JSONObject.fromObject(jsonObject.getString("data"));
		String pageNumber=jsonObject2.getString("pageNumber");
		String pageSize=jsonObject2.getString("pageSize");
		try{
			
			PageBean<Article> articlePages=articleService.findByPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize),new Article());
			Map<String,Object> findMap=new HashMap<String,Object>();
			List<Map<String,Object>> mapList=new ArrayList<Map<String,Object>>();
			if(null!=articlePages){
				for(Article article:articlePages.getLists()){
					findMap.put("id",article.getArticleId());
					findMap.put("title",article.getTitle());
					//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					//String time=format.format(article.getPublishTime());
					findMap.put("pushTime",article.getPublishTime());
					mapList.add(findMap);
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
	
	@RequestMapping(value="/appFindArticleById",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> appFindArticleById(@RequestBody String data){
		System.out.println("data:"+data);
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(data);
		JSONObject jsonObject2=JSONObject.fromObject(jsonObject.getString("data"));
		String articleId=jsonObject2.getString("articleId");		
		try{
			Article article=articleService.selectByPrimaryKey(Integer.parseInt(articleId));
			Map<String,Object> findMap=new HashMap<String,Object>();
			if(null!=article){
				findMap.put("id",article.getArticleId());
				findMap.put("title",article.getTitle());
				findMap.put("appContent",article.getAppContent());
				//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				//String time=format.format(article.getPublishTime());
				findMap.put("pushTime",article.getPublishTime());
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
