package com.spaceeye.controller.app;

import java.util.HashMap;
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
import com.spaceeye.service.IAppInformationService;

@Controller
public class AppInformationController {
	@Autowired
	private IAppInformationService appInformationService;
	
	@RequestMapping(value="/appFindInformation",method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> appFindInformation(@RequestBody String data){
		System.out.println("data:"+data);
		Map<String,Object> map=new HashMap<String,Object>();
		JSONObject jsonObject = JSONObject.fromObject(data);
		JSONObject jsonObject2=JSONObject.fromObject(jsonObject.getString("data"));
		String type=jsonObject2.getString("type");
		try{
			AppInformation appInformation=appInformationService.findAppInformation();
			if(null!=appInformation){
				map.put("status", "200");
				map.put("mgs","查询成功");
				if("1".equals(type) && (""!=appInformation.getHelpCenter() && null!=appInformation.getHelpCenter())){
					Map<String,Object> helpMap=new HashMap<String,Object>();
					helpMap.put("id", appInformation.getAppInformationId());
					helpMap.put("helpCenter",appInformation.getHelpCenter());
					map.put("result",helpMap);
					return map;
					
				}else if("2".equals(type) && (""!=appInformation.getContactUs() && null!=appInformation.getContactUs())){
					Map<String,Object> contactMap=new HashMap<String,Object>();
					contactMap.put("id", appInformation.getAppInformationId());
					contactMap.put("contactUs",appInformation.getContactUs());
					map.put("result",contactMap);
					return map;
					
				}else if("3".equals(type) && (""!=appInformation.getImprint() && null!=appInformation.getImprint())){
					Map<String,Object> imprintMap=new HashMap<String,Object>();
					imprintMap.put("id", appInformation.getAppInformationId());
					imprintMap.put("imprint",appInformation.getImprint());
					map.put("result",imprintMap);
					return map;
					
				}else{
					map.put("status", "200");
					map.put("mgs","暂无数据");
					return map;
				}
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
