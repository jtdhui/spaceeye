package com.spaceeye.service;

import java.util.List;

import com.spaceeye.dto.Article;
import com.spaceeye.dto.PageBean;
import com.spaceeye.dto.Satellite;

public interface IArticleService {
	
	int deleteByPrimaryKey(Integer id);

    int saveArticle(Article article);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectArticleList();

    int selectCount();

    int updateByPrimaryKey(Article article);

    PageBean<Article> findByPage(int currentPage,int pageSize,Article article);
    
    List<Article> findSatelliteByBhao(String bhao);
    
    void  updateArticle(Article article);

}
