package com.spaceeye.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceeye.dao.IArticleDao;
import com.spaceeye.dto.Article;
import com.spaceeye.dto.PageBean;
import com.spaceeye.service.IArticleService;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDao articleDao;
	
	@Override
	public int deleteByPrimaryKey(Integer articleId) {
		return articleDao.deleteByPrimaryKey(articleId);
	}
	@Override
	public Article selectByPrimaryKey(Integer articleId) {

		return articleDao.selectByPrimaryKey(articleId);
	}

	@Override
	public List<Article> selectArticleList() {
	
		return null;
	}

	@Override
	public int selectCount() {
		
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Article article) {		
		Article findArticle=articleDao.selectByPrimaryKey(article.getArticleId());
		Map<String,String> map=new HashMap<String,String>();
		map.put("title",findArticle.getTitle());
		map.put("category","0");
		map.put("articleId",findArticle.getArticleId()+"");
		JPushService jPushService=new JPushService();
		jPushService.sendPushAll(map);
		return articleDao.updateByPrimaryKey(article);
	}

	@Override
	public PageBean<Article> findByPage(int currentPage,int pageSize,Article article) {
		    HashMap<String,Object> map = new HashMap<String,Object>();
	        PageBean<Article> pageBean = new PageBean<Article>();
	        //封装当前页数
	        pageBean.setCurrPage(currentPage);
	        //每页显示的数据
	        pageBean.setPageSize(pageSize);
	        //封装总记录数
	        int totalCount = articleDao.selectCount(article);
	        pageBean.setTotalCount(totalCount);
	        //封装总页数
	        double tc = totalCount;
	        Double num =Math.ceil(tc/pageSize);//向上取整
	        pageBean.setTotalPage(num.intValue());
	        map.put("start",(currentPage-1)*pageSize);
	        map.put("size", pageBean.getPageSize());
	        map.put("title",article.getTitle());
	        map.put("satelliteBhao",article.getSatelliteBhao());
	        map.put("categoryId",article.getCategoryId());
	        //封装每页显示的数据
	        List<Article> lists = articleDao.findByPage(map);
	        pageBean.setLists(lists);

	        return pageBean;
	}

	@Override
	public int saveArticle(Article article) {		
		return articleDao.saveArticle(article);
	}
	@Override
	public List<Article> findSatelliteByBhao(String bhao) {		
		return articleDao.findSatelliteByBhao(bhao);
	}
	@Override
	public void updateArticle(Article article) {
		articleDao.updateByPrimaryKey(article);
		
	}
	


}
