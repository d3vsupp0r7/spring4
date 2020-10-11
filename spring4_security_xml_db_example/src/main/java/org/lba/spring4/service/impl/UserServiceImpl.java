package org.lba.spring4.service.impl;

import org.lba.spring4.db.model.UserInfo;
import org.lba.spring4.db.repository.UserRepository;
import org.lba.spring4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserInfo getDataByUserName(String userName) {
		UserInfo activeUserInfo = userRepository.getActiveUser(userName,1);
		return activeUserInfo;
	}
}
