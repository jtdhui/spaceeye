package com.spaceeye.dao;

import com.spaceeye.dto.AppInformation;

/**
 * Created by chenhui on 2018/1/23.
 */
public interface IAppInformationDao {
	
	public void insertAppInformation(AppInformation appInformation);

	public AppInformation findAppInformation();

	public void updateAppInformation(AppInformation appInformation);

}
