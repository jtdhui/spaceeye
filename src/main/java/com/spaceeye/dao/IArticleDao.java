package com.spaceeye.dao;

import java.util.HashMap;
import java.util.List;

import com.spaceeye.dto.Article;

public interface IArticleDao {
	
	   // 根据条件查询总记录数
	   int selectCount(Article article);
	   
	   // 分页操作，调用findByPage limit分页方法
       List<Article> findByPage(HashMap<String,Object> map);
       
       // 保存
       int saveArticle(Article article);
       
       // 根据主键查询
       Article selectByPrimaryKey(int articleId);
       
       // 根据主键修改
       int updateByPrimaryKey(Article article);
       
       // 根据主键删除
       int deleteByPrimaryKey(int articleId);
       
       // 根据卫星编号查询文章
       List<Article> findSatelliteByBhao(String bhao);
}
