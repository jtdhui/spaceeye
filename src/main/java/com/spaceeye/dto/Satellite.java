package com.spaceeye.dto;

import java.util.Date;

public class Satellite {	
	private Integer satelliteId;
	private String satelliteName;
	private String detail;//后台编辑详情
	private String appDetail;//app编辑详情
	private Date editorTime;//编辑时间
	public Date getEditorTime() {
		return editorTime;
	}
	public void setEditorTime(Date editorTime) {
		this.editorTime = editorTime;
	}
	public String getAppDetail() {
		return appDetail;
	}
	public void setAppDetail(String appDetail) {
		this.appDetail = appDetail;
	}
	public Integer getSatelliteId() {
		return satelliteId;
	}
	public void setSatelliteId(Integer satelliteId) {
		this.satelliteId = satelliteId;
	}
	public String getSatelliteName() {
		return satelliteName;
	}
	public void setSatelliteName(String satelliteName) {
		this.satelliteName = satelliteName;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	

}
