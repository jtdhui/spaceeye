package com.spaceeye.controller.admin;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spaceeye.dto.Databable;
import com.spaceeye.service.IDatabableService;
import com.spaceeye.service.ISatelliteService;

@Controller
@RequestMapping("/datatable")
public class DatabableController {
	
	@Autowired
	private IDatabableService datatableService;
	
	@Autowired
	private ISatelliteService satelliteService;
	
	
	@RequestMapping("/saveDatatable")
	public String saveDatatable(Databable databable){
		
		datatableService.saveDatabable(databable);
		
		return "/databable/databableList";
	}
	
	@RequestMapping("/findDatatableList")
	public String findDatatableList(Model model,String currentPage,String pageSize){
		
		int showPageSize=1;
		int pageNumber=1;
		if(!"".equals(pageSize) && null!=pageSize){
			showPageSize=Integer.parseInt(pageSize);
		}
		if(!"".equals(currentPage) && null!=currentPage){
			pageNumber=Integer.parseInt(currentPage);
		}
		model.addAttribute("pagemsg", datatableService.findByPage(pageNumber,showPageSize));
		
		return "/databable/databableList";
	}
	
	 @RequestMapping(value="/upload",method=RequestMethod.POST)
     public String upload(HttpServletRequest request,
            @RequestParam("file") MultipartFile file,String imprint) throws Exception {
        //如果文件不为空，写入上传路径
        if(!file.isEmpty()) {
            //上传文件路径
            String path = request.getServletContext().getRealPath("/sql/");
            Date date=new Date();
            SimpleDateFormat sp=new SimpleDateFormat("yyyyMMddHHmmss");
            String dateString= sp.format(date);
            path=path+"/"+dateString;
            //上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            //判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) { 
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件当中
            file.transferTo(new File(path + File.separator + filename));
            try{
            	 uploadSql(path + File.separator + filename);            	
	       		 //保存数据库版本信息
	       		 Databable databable=new Databable();
	       		 databable.setPushTime(new Date());
	       		 databable.setImprint(imprint);
	       		 databable.setVersionNumber(date.getTime());
	       		databable.setFilePath("/sql/"+dateString);
	       		 datatableService.saveDatabable(databable);
            }catch(Exception e){
            	 e.printStackTrace(); 
            }
            
          return "redirect:/datatable/findDatatableList";
        } else {
            return "error";
        }

     }
	 
	 public void uploadSql(String sqlFile){				 
		 //保存卫星数据
		 satelliteService.saveSatellite(sqlFile);
	 }

}
