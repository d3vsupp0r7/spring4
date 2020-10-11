package org.lba.spring4.service.security;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.lba.spring4.db.model.UserInfo;
import org.lba.spring4.db.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyAppUserDetailsService implements UserDetailsService {

	static final Logger logger = Logger.getLogger(MyAppUserDetailsService.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserDetails userDetails = null;
		
		UserInfo activeUserInfo = userRepository.getActiveUser(userName,1);
		if(activeUserInfo!=null) {
			logger.debug("*** User found: " + userName);
			GrantedAuthority authority = new SimpleGrantedAuthority(activeUserInfo.getRole());
			userDetails = (UserDetails)new User(activeUserInfo.getUserName(),
				activeUserInfo.getPassword(), Arrays.asList(authority));
		}else {
			logger.debug("*** User not found: " + userName);
			 throw new UsernameNotFoundException("User not authorized.");
		}
		return userDetails;
	}

}
