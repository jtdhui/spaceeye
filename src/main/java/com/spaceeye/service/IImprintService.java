package com.spaceeye.service;

import org.springframework.stereotype.Service;




import com.spaceeye.dto.AppInformation;
import com.spaceeye.dto.Imprint;

/**
 * Created by chenhui on 2018/1/23.
 */
@Service
public interface IImprintService {
	
	public void save(Imprint imprint);

	public Imprint findImprint();

	public void update(Imprint imprint);
	
	
}
