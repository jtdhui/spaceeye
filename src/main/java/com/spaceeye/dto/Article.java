package com.spaceeye.dto;

import java.util.Date;

public class Article {	
	public Integer articleId;
	public String title;
	public String content;
	public String appContent;
	public String satelliteBhao;	
	public Date publishTime;
	public String status;
	public String categoryId;
	public String type;
	public String reprint;

	public String getReprint() {
		return reprint;
	}
	public void setReprint(String reprint) {
		this.reprint = reprint;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSatelliteBhao() {
		return satelliteBhao;
	}
	public void setSatelliteBhao(String satelliteBhao) {
		this.satelliteBhao = satelliteBhao;
	}
	public String getAppContent() {
		Boolean b= null;
		return appContent;
	}
	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}

	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public String getStatus() {
		return status;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public void setStatus(String status) {
		this.status = status;
	}


}
