package com.spaceeye.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceeye.dao.IImprintDao;
import com.spaceeye.dto.Imprint;
import com.spaceeye.service.IImprintService;


@Service
public class ImprintService implements IImprintService {
	
	@Autowired
	private IImprintDao imprintDao;

	@Override
	public void save(Imprint imprint) {
		imprintDao.insertImprint(imprint);
		
	}

	@Override
	public Imprint findImprint() {
		return imprintDao.findImprint();
	}

	@Override
	public void update(Imprint imprint) {
	
		imprintDao.updateImprint(imprint);
	}


}
