package com.spaceeye.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spaceeye.dto.Imprint;
import com.spaceeye.service.IImprintService;

@Controller
public class ImprintController {
	
	@Autowired
	private IImprintService imprintService;
	
	@RequestMapping("/findImprint")
	public String findImprint(Model model){
		Imprint imprint=imprintService.findImprint();
		model.addAttribute("imprint",imprint);
		return "/imprint/updateImprint";
	}	
	@RequestMapping("/saveImprint")
	public String saveImprint(Imprint imprint){
		Imprint findImprint=imprintService.findImprint();		
		if(findImprint!=null){
			imprint.setImprintId(findImprint.getImprintId());
			imprintService.update(imprint);
		}else{
			imprintService.save(imprint);
		}
        return "redirect:/findImprint";
	}

}
