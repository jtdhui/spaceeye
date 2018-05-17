package com.spaceeye.controller.admin;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceeye.dto.Satellite;
import com.spaceeye.service.ISatelliteService;

@Controller
public class SatelliteController {
	
	@Autowired
	private ISatelliteService satelliteService;
	
	@RequestMapping("/satelliteList")
	public String satelliteList(Model model){		
	     List<Satellite> satelliteList=	satelliteService.findSatelliteList();
	     model.addAttribute("satelliteList",satelliteList);
	     return "/satellite/satelliteList";
	}
	//跳转到添加卫星详情页面
	@RequestMapping("/toAddOrUpdateSatellite")
	public String toAddOrUpdateSatellite(Model model,String satelliteId){
		model.addAttribute("satelliteId",satelliteId);
		 return "/satellite/updateSatellite";
	}
	//保存卫星详情
	@RequestMapping("/saveSatellite")
	public String saveSatellite(Satellite satellite,Model model,String satelliteId){
		if(""!=satelliteId && null!=satelliteId){
			satellite.setSatelliteId(Integer.parseInt(satelliteId.trim()));
			satellite.setEditorTime(new Date());
			satelliteService.updateByPrimaryKey(satellite);
		}
		 return "redirect:/findArticleList?type=1";
	}
	
	//模糊查询卫星
	@RequestMapping("/findSatelliteLikeBhao")
	@ResponseBody
	public List<String> findSatelliteLikeBhao(String bhao){
		List<String> bhaoNames=satelliteService.findSatelliteLikeBhao(bhao);
		return bhaoNames;
	}

}
