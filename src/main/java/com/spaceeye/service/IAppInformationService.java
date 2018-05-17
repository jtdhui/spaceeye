package com.spaceeye.service;

import org.springframework.stereotype.Service;



import com.spaceeye.dto.AppInformation;

/**
 * Created by chenhui on 2018/1/23.
 */
@Service
public interface IAppInformationService {
	
	public void save(AppInformation appInformation);

	public AppInformation findAppInformation();

	public void update(AppInformation appInformation);
	
	
}
