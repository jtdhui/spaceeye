package com.spaceeye.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spaceeye.dto.AppInformation;
import com.spaceeye.service.IAppInformationService;

/**
 * Created by chenhui on 2018/1/23.
 */
@Controller
public class AdminAppInformationController {
	
	@Autowired
	private IAppInformationService appInformationService;

	@RequestMapping("/saveAppInformation")
	public String saveAppInformation(AppInformation appInformation,String type){	
		AppInformation findAppInformation=appInformationService.findAppInformation();
		if(findAppInformation!=null){	
			appInformation.setAppInformationId(findAppInformation.getAppInformationId());
			appInformationService.update(appInformation);
		}else{
			appInformationService.save(appInformation);
		}
		return "redirect:/findAppInformation?type="+type;
	}
	
	@RequestMapping("/findAppInformation")
	public String findAppInformation(Model model,String type){		
		AppInformation appInformation=appInformationService.findAppInformation();
		model.addAttribute("appInformation",appInformation);
		model.addAttribute("type",type);
		if(type.equals("1")){
			return "/appInformation/updateHelpCenter";
		}else if(type.equals("2")){
			return "/appInformation/updateContactUs";
		}else if(type.equals("3")){
			return "/appInformation/updateImprint";
		}
		
		return null;
	}


}
