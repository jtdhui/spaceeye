package com.spaceeye.dto;

import java.io.Serializable;

/**
 * Created by chenhui on 2018/1/23.
 */
public class AppInformation implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer appInformationId;
    private String helpCenter;//帮助中心
    private String contactUs;//联系我们
    private String imprint; //版本信息

	public String getImprint() {
		return imprint;
	}
	public void setImprint(String imprint) {
		this.imprint = imprint;
	}
	
	public Integer getAppInformationId() {
		return appInformationId;
	}
	public void setAppInformationId(Integer appInformationId) {
		this.appInformationId = appInformationId;
	}
	public String getHelpCenter() {
		return helpCenter;
	}
	public void setHelpCenter(String helpCenter) {
		this.helpCenter = helpCenter;
	}
	public String getContactUs() {
		return contactUs;
	}
	public void setContactUs(String contactUs) {
		this.contactUs = contactUs;
	}

    
}
