package com.spaceeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceeye.dao.IAppInformationDao;
import com.spaceeye.dto.AppInformation;
import com.spaceeye.service.IAppInformationService;


@Service
public class AppInformationService implements IAppInformationService {
	
	@Autowired
	private IAppInformationDao appInformationDao;

	@Override
	public void save(AppInformation appInformation) {
		// TODO Auto-generated method stub
		appInformationDao.insertAppInformation(appInformation);
	}

	@Override
	public AppInformation findAppInformation() {
		// TODO Auto-generated method stub
		return appInformationDao.findAppInformation();
	}

	@Override
	public void update(AppInformation appInformation) {
		// TODO Auto-generated method stub
		appInformationDao.updateAppInformation(appInformation);
	}






}
