package com.spaceeye.controller.admin;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spaceeye.dto.Article;
import com.spaceeye.dto.PageBean;
import com.spaceeye.dto.Satellite;
import com.spaceeye.service.IArticleService;
import com.spaceeye.service.ISatelliteService;

@Controller
public class ArticleController {
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private ISatelliteService satelliteService;

	
	@RequestMapping("/findArticleList")
	public String findArticleList(Model model,String currentPage,String pageSize,Article article,String name,String type){	
		int showPageSize=10;
		int pageNumber=1;
		if(!"".equals(pageSize) && null!=pageSize){
			showPageSize=Integer.parseInt(pageSize);
		}
		if(!"".equals(currentPage) && null!=currentPage){
			pageNumber=Integer.parseInt(currentPage);
		}
		if("1".equals(type)){
			article.setCategoryId("1");
		}
		if("0".equals(type)){
			article.setCategoryId("0");
		}
		model.addAttribute("pagemsg", articleService.findByPage(pageNumber,showPageSize,article));
		model.addAttribute("article",article);
		model.addAttribute("name",name);
		return "informationManage/articleList";
	}
	@RequestMapping("/toAddOrUpdateArticle")
	public String toAddOrUpdateArticle(Model model,String articleId,String type){
		if(""!=articleId && null!=articleId){
			Article article=articleService.selectByPrimaryKey(Integer.parseInt(articleId));
			model.addAttribute("article",article);
		}
		List<Satellite> satelliteList=satelliteService.findSatelliteList();
		model.addAttribute("satelliteList",satelliteList);
		model.addAttribute("type",type);
		return "informationManage/addOrUpdateArticle";
	}
	@RequestMapping("/saveArticle")
	public String saveArticle(Model model,String type,String articleId,Article article){
		article.setStatus("0");
		article.setPublishTime(new Date());
		article.setReprint("0");
		if(""!=articleId && null!=articleId){
			article.setArticleId(Integer.parseInt(articleId));
			articleService.updateByPrimaryKey(article);
		}else{
			articleService.saveArticle(article);
		}		 
        return "redirect:/findArticleList?type="+type;
	}
	@RequestMapping("/deleteArticle")
	public String deleteArticle(Model model,String type,String articleId){
		articleService.deleteByPrimaryKey(Integer.parseInt(articleId));		
        return "redirect:/findArticleList?currentPage=1";
	}
	@RequestMapping("/findArticleListJson")
	@ResponseBody
	public  PageBean<Article> findArticleListJson(String pageSize,String currentPage,Article article){	
		int showPageSize=10;
		int pageNumber=1;
		if(!"".equals(pageSize) && null!=pageSize){
			showPageSize=Integer.parseInt(pageSize);
		}
		if(!"".equals(currentPage) && null!=currentPage){
			pageNumber=Integer.parseInt(currentPage);
		}
		PageBean<Article> articlePages=articleService.findByPage(pageNumber,showPageSize,article);	
		return articlePages;
	}
	@RequestMapping("/updateArticle")
	public String updateArticle(Model model,String articleIds,String bhao,String name){
		  String[] ids =articleIds.split(",");
		  for(String id:ids){
			  Article article=new Article();
			  article.setSatelliteBhao(bhao);
			  article.setArticleId(Integer.parseInt(id));
			  article.setReprint("1");
			  articleService.updateByPrimaryKey(article);
		  }
        return "redirect:/findArticleList?categoryId=1&name="+name+"&satelliteBhao="+bhao;
	}
	@RequestMapping("/pushArticle")
	public String pushArticle(Model model,String articleId){
		   Article article=new Article();
		   article.setArticleId(Integer.parseInt(articleId));
		   article.setStatus("1");
           articleService.updateByPrimaryKey(article);

        return "redirect:/findArticleList?categoryId=0";
	}
}
