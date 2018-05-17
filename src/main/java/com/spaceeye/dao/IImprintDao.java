package com.spaceeye.dao;

import com.spaceeye.dto.Imprint;
public interface IImprintDao {
	
	public void insertImprint(Imprint imprint);

	public Imprint findImprint();

	public void updateImprint(Imprint imprint);

}
