package com.spaceeye.dto;

import java.util.Date;

public class Databable {
	
	private Integer datatableId;
	private Date pushTime; //上传时间
	private String imprint; //版本说明
	private Long versionNumber;//版本号
	private String filePath;//文件上传路径
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getDatatableId() {
		return datatableId;
	}
	public void setDatatableId(Integer datatableId) {
		this.datatableId = datatableId;
	}
	public Date getPushTime() {
		return pushTime;
	}
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
	public String getImprint() {
		return imprint;
	}
	public void setImprint(String imprint) {
		this.imprint = imprint;
	}
	public Long getVersionNumber() {
		return versionNumber;
	}
	public void setVersionNumber(Long versionNumber) {
		this.versionNumber = versionNumber;
	}

	
	

}
