package com.spaceeye.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spaceeye.dao.IUserDao;
import com.spaceeye.dto.User;
import com.spaceeye.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDao userDao;

	@Override
	public User findUser(User user) {

		return userDao.findUser(user);
	}

}
